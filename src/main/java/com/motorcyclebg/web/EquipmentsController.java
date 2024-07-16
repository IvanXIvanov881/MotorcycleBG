package com.motorcyclebg.web;

import com.motorcyclebg.service.EquipmentService;
import com.motorcyclebg.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipments")
public class EquipmentsController {

    private final EquipmentService equipmentsService;

    public EquipmentsController(EquipmentService equipmentsService) {
        this.equipmentsService = equipmentsService;
    }


    @GetMapping("/all")
    public String getAllEquipments(Model model){

        model.addAttribute("allEquipments", equipmentsService.getAllEquipmentSummary());
        return "equipments";
    }

}
