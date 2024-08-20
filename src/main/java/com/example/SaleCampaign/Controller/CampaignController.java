package com.example.SaleCampaign.Controller;

import com.example.SaleCampaign.Model.Campaign;
import com.example.SaleCampaign.Model.Product;
import com.example.SaleCampaign.Repository.ProductRepository;
import com.example.SaleCampaign.Services.CampaignServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignServices campaignServices;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addCampaign")
    public void addCampaign(@RequestBody Campaign campaign){
        campaignServices.addCampaign(campaign);
    }
    @PutMapping("/startCampaign")
    public void getStartCampaign(){
        campaignServices.getStartCampaign();
    }

    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam int pid){
        return productRepository.findById(pid).get();
    }
    @PutMapping("/endCampaign")
    public void  getEndCampaign(){
        campaignServices.getEndCampaign();
    }
}
