package com.motorcyclebg.web;

import com.motorcyclebg.model.dto.AddEquipmentDTO;
import com.motorcyclebg.model.dto.EquipmentDetailsDTO;
import com.motorcyclebg.model.enums.EquipmentConditionTypeEnum;
import com.motorcyclebg.model.enums.EquipmentTypeEnum;
import com.motorcyclebg.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @ModelAttribute("allEquipmentTypes")
    public EquipmentTypeEnum[] allEquipmentTypes() {
        return EquipmentTypeEnum.values();
    }


    @ModelAttribute("allEquipmentConditionTypes")
    public EquipmentConditionTypeEnum[] allEquipmentConditionTypes() {
        return EquipmentConditionTypeEnum.values();
    }


    @GetMapping("/add")
    public String newEquipment(Model model) {

        if (!model.containsAttribute("addEquipmentDTO")) {
            model.addAttribute("addEquipmentDTO", new AddEquipmentDTO());
        }
        return "equipment-add";
    }

    @PostMapping("add")
    public String createEquipment(
            @Valid AddEquipmentDTO addEquipmentDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("addEquipmentDTO", addEquipmentDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addEquipmentDTO", bindingResult);
            return "redirect:/equipments/add";
        }

        equipmentService.createEquipment(addEquipmentDTO);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String equipmentDetails(@PathVariable("id") Long id,
                               Model model) {

        EquipmentDetailsDTO equipmentDetailsDTO = equipmentService.getEquipmentDetails(id);
        model.addAttribute("equipmentDetails", equipmentDetailsDTO);

        return "equipment-details";
    }

    @DeleteMapping("/details/{id}")
    public String deleteEquipment(@PathVariable("id") Long id) {

        equipmentService.deleteEquipment(id);

        return "redirect:/equipments/all";
    }

    @GetMapping("/all")
    public String getAllEquipments(Model model){

        model.addAttribute("allEquipments", equipmentService.getAllEquipmentSummary());
        return "equipments";
    }

    //TODO Fix that "update" of equipment
    @PatchMapping("/details/{id}")
    public String editEquipmentDetails(@PathVariable("id") Long id,
                                   Model model) {

        model.addAttribute("editEquipmentDetails", equipmentService.getEquipmentDetails(id));

        return "details";
    }

}

