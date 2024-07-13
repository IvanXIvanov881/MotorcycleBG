package com.motorcyclebg.web;

import com.motorcyclebg.model.dto.AddOfferDTO;
import com.motorcyclebg.model.dto.OfferDetailsDTO;
import com.motorcyclebg.model.enums.*;
import com.motorcyclebg.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("allBrandTypes")
    public BrandTypeEnum[] allBrandTypes() {
        return BrandTypeEnum.values();
    }

    @ModelAttribute("allCategoryTypes")
    public CategoryTypeEnum[] allCategoryTypes() {
        return CategoryTypeEnum.values();
    }

    @ModelAttribute("allEngineTypes")
    public EngineTypeEnum[] allEngineTypes() {
        return EngineTypeEnum.values();
    }

    @ModelAttribute("allTransmissionTypes")
    public TransmissionTypeEnum[] allTransmissionTypes() {
        return TransmissionTypeEnum.values();
    }

    @ModelAttribute("allConditionTypes")
    public ConditionTypeEnum[] allConditionTypes() {
        return ConditionTypeEnum.values();
    }


    @GetMapping("/add")
    public String newOffer(Model model) {

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", new AddOfferDTO());
        }
        return "offer-add";
    }

    @PostMapping("add")
    public String createOffer(
            @Valid AddOfferDTO addOfferDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("addOfferDTO", addOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }

        offerService.createOffer(addOfferDTO);
        return "redirect:/offers/all";
    }

    @GetMapping("/details/{id}")
    public String offerDetails(@PathVariable("id") Long id,
                               Model model) {

        OfferDetailsDTO offerDetailsDTO = offerService.getOfferDetails(id);
        model.addAttribute("offerDetails", offerDetailsDTO);
        System.out.println();

        return "details";
    }

    @DeleteMapping("/details/{id}")
    public String deleteOffer(@PathVariable("id") Long id) {

        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    //TODO Fix that "update" of offer
    @PatchMapping("/details/{id}")
    public String editOfferDetails(@PathVariable("id") Long id,
                                   Model model) {

        model.addAttribute("editOfferDetails", offerService.getOfferDetails(id));

        return "details";
    }

    //TODO that method is for delete (we using globalExceptionHandler)
    //@ResponseStatus(code = HttpStatus.NOT_FOUND)
    //  @ExceptionHandler(ObjectNotFoundException.class)
    //  public ModelAndView handleObjectNotFound(ObjectNotFoundException onfe) {
    //    ModelAndView modelAndView = new ModelAndView("offer-not-found");
    //    modelAndView.addObject("offerId", onfe.getId());
    //
    //    return modelAndView;
    //  }

}
