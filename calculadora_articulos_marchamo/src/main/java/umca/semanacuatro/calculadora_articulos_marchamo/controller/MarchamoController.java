package umca.semanacuatro.calculadora_articulos_marchamo.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import umca.semanacuatro.calculadora_articulos_marchamo.dto.MarchamoDto;


@Controller
public class MarchamoController {

    private static final List<MarchamoDto> resultadosMarchamo = new ArrayList<>();

     @GetMapping("/calculadora_marchamo")
    public String form(Model model) {

        model.addAttribute("calculadoraData", new MarchamoDto());

        return "formCalculadoraMarchamo";
    }

    @PostMapping("/calcularMarchamo")
    public String calcular(@ModelAttribute("calculadoraData") MarchamoDto data, Model model) {
        
        Double valorFiscal = data.getValorFiscal();
        Double porcentajeINS = 0.05;
        String tipoVehiculo = data.getTipoVehiculo();
        Double porcentajeCobro = 0.0;
        String conoceFigueres = data.getConoceFigueres();

        switch (tipoVehiculo)
        {
            case "CL":
            porcentajeCobro = 0.05;
            break;

            case "AB":
            porcentajeCobro = 0.0475;
            break;

            case "MT":
            porcentajeCobro = 0.03;

            default:
            porcentajeCobro = 0.0;
        }

        if ("Sí".equalsIgnoreCase(conoceFigueres))
        {
            porcentajeCobro = porcentajeCobro + 0.10;
        }

        Double resultadoMarchamo = (valorFiscal * porcentajeCobro) + (valorFiscal * porcentajeINS);

        DecimalFormat df = new DecimalFormat("#,###");
        DecimalFormat dfPorcentaje = new DecimalFormat("#,##0.00");

        data.setResultadoMarchamo(resultadoMarchamo);
        resultadosMarchamo.add(data);

        model.addAttribute("valorFiscal", df.format(valorFiscal));
        model.addAttribute("porcentajeCobro", dfPorcentaje.format(porcentajeCobro * 100));
        model.addAttribute("resultadoMarchamo", df.format(resultadoMarchamo));
        model.addAttribute("conoceFigueres", conoceFigueres);

        return "redirect:/resultadoCalculadoraMarchamo";
    }

    @GetMapping("/resultadoCalculadoraMarchamo")
    public String resultadoMarchamo(Model model) {

        if (! resultadosMarchamo.isEmpty())
        {
            MarchamoDto ultimoResultado = resultadosMarchamo.get(resultadosMarchamo.size() - 1);

            DecimalFormat df = new DecimalFormat("#,###");
            DecimalFormat dfPorcentaje = new DecimalFormat("#,##0.00");

            model.addAttribute("valorFiscal", df.format(ultimoResultado.getValorFiscal())); 
            model.addAttribute("porcentajeCobro", dfPorcentaje.format((ultimoResultado.getResultadoMarchamo() - (ultimoResultado.getValorFiscal() * 0.05)) / ultimoResultado.getValorFiscal() * 100));
            model.addAttribute("resultadoMarchamo", df.format(ultimoResultado.getResultadoMarchamo())); 
            model.addAttribute("conoceFigueres", ultimoResultado.getConoceFigueres());
        }

        return "resultadoCalculadoraMarchamo";
    }

}
