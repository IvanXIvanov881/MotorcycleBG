package com.motorcyclebg.web;

import com.motorcyclebg.model.dto.AddPartsDTO;
import com.motorcyclebg.model.dto.PartsDetailsDTO;
import com.motorcyclebg.model.enums.PartsConditionTypeEnum;
import com.motorcyclebg.model.enums.PartsTypeEnum;
import com.motorcyclebg.service.PartsService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/parts")
public class PartsController {


        private final PartsService partsService;

        public PartsController(PartsService partsService) {
            this.partsService = partsService;
        }

        @ModelAttribute("allPartsTypes")
        public PartsTypeEnum[] allPartsTypes() {
            return PartsTypeEnum.values();
        }


        @ModelAttribute("allPartsConditionTypes")
        public PartsConditionTypeEnum[] allPartsConditionTypes() {
            return PartsConditionTypeEnum.values();
        }


        @GetMapping("/add")
        public String newParts(Model model) {

            if (!model.containsAttribute("addPartsDTO")) {
                model.addAttribute("addPartsDTO", new AddPartsDTO());
            }
            return "parts-add";
        }

        @PostMapping("add")
        public String createParts(
                @Valid AddPartsDTO addPartsDTO,
                BindingResult bindingResult,
                RedirectAttributes rAtt) {

            if (bindingResult.hasErrors()) {
                rAtt.addFlashAttribute("addEquipmentDTO", addPartsDTO);
                rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addPartsDTO", bindingResult);
                return "redirect:/parts/add";
            }

            partsService.createParts(addPartsDTO);
            return "redirect:/";
        }

        @GetMapping("/details/{id}")
        public String equipmentDetails(@PathVariable("id") Long id,
                                       Model model) {

            PartsDetailsDTO partsDetailsDTO = partsService.getPartsDetails(id);
            model.addAttribute("partsDetails", partsDetailsDTO);

            return "parts-details";
        }

        @DeleteMapping("/details/{id}")
        public String deleteParts(@PathVariable("id") Long id) {

            partsService.deleteParts(id);

            return "redirect:/parts/all";
        }

        @GetMapping("/all")
        public String getAllParts(Model model){

            model.addAttribute("allParts", partsService.getAllPartsSummary());
            return "parts";
        }

        //TODO Fix that "update" of parts
        @PatchMapping("/details/{id}")
        public String editPartsDetails(@PathVariable("id") Long id,
                                           Model model) {

            model.addAttribute("editEquipmentDetails", partsService.getPartsDetails(id));

            return "parts-details";
        }

    }