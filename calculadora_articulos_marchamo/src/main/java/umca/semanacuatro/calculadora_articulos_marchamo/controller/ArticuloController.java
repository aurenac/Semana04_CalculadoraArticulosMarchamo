package umca.semanacuatro.calculadora_articulos_marchamo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import umca.semanacuatro.calculadora_articulos_marchamo.dto.ArticuloDto;

@Controller
public class ArticuloController {

    @GetMapping("/calculadora_articulos")
    public String form(Model model) {
        model.addAttribute("articuloData", new ArticuloDto());
        return "formCalculadoraArticulos";
    }

    @PostMapping("/calcularArticulos")
    public String calcular(@ModelAttribute("articuloData") ArticuloDto data, Model model) {

        Double costo = data.getCosto();
        Double porcentajeGanancia = data.getPorcentajeGanancia();
        Boolean aplicaImpuestoVentas = data.getAplicaImpuestoVentas();
        Double impuestoVentas = 0.0;
        Double montoGanancia = costo * (porcentajeGanancia / 100);
        Double precioFinal = costo + montoGanancia;
        Double montoImpuestoVentas = 0.0;

        if (aplicaImpuestoVentas != null && aplicaImpuestoVentas) {
            
            if (data.getImpuestoVentas() != null) 
            {
                impuestoVentas = data.getImpuestoVentas() / 100; // Convertir a porcentaje
                montoImpuestoVentas = (costo + montoGanancia) * impuestoVentas; // Calcular monto de impuesto
                precioFinal = precioFinal + montoImpuestoVentas;
            }
        }

        data.setMontoGanancia(montoGanancia);
        data.setPrecioFinal(precioFinal);

        model.addAttribute("costo", costo);
        model.addAttribute("montoGanancia", montoGanancia);
        model.addAttribute("precioFinal", precioFinal);
        model.addAttribute("montoImpuestoVentas", montoImpuestoVentas);

        return "resultadoCalculadoraArticulos";
    }

    @GetMapping("/resultadoCalculadoraArticulos")

        public String resultadoArticulo(Model model) {
            return "resultadoCalculadoraArticulos";
    }
}
