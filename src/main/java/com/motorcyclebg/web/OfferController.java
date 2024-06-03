package com.motorcyclebg.web;

import com.motorcyclebg.model.AddOfferDTO;
import com.motorcyclebg.model.enums.EngineTypeEnum;
import com.motorcyclebg.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/add")
    public String newOffer(Model model) {

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.empty());
        }
        model.addAttribute("allEngineTypes", EngineTypeEnum.values());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String createOffer(AddOfferDTO addOfferDTO) {

        offerService.createOrder(addOfferDTO);

        // TODO:
        return "offer-add";
    }
}
