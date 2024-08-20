package com.example.SaleCampaign.Services;


import com.example.SaleCampaign.Model.Campaign;
import com.example.SaleCampaign.Model.Discount;
import com.example.SaleCampaign.Model.History;
import com.example.SaleCampaign.Model.Product;
import com.example.SaleCampaign.Repository.CampaignRepository;
import com.example.SaleCampaign.Repository.HistoryRepository;
import com.example.SaleCampaign.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
@EnableScheduling
public class CampaignServices {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private HistoryRepository historyRepository;

    public void addCampaign(Campaign campaign){
        for (int i = 0; i <campaign.getDiscounts().size(); i++) {
            Discount discount = campaign.getDiscounts().get(i);
            discount.setCampaign(campaign);
        }
        campaignRepository.save(campaign);
    }

     @Scheduled(cron = "0 0 0 * * *")
        public void getStartCampaign(){
         System.out.println("Start");
        List<Object[]>campaigns=campaignRepository.getStartCampaign();


        for (Object[] objects:campaigns){
            Campaign campaign=campaignRepository.findById((int)objects[0]).get();
            List<Discount>discounts=campaign.getDiscounts();
            for (Discount discount:discounts){
                Product product=productRepository.findById(discount.getProduct().getpId()).get();

                History history=new History();
                double hisDiscount = product.getDiscount();

                history.setDiscount(hisDiscount);
                history.setPrice(product.getCurrentPrice());
                history.setLocalDate(campaign.getStartDate());
                history.setProduct(product);

                double dis=(product.getCurrentPrice()*discount.getdRete())/100;
                product.setCurrentPrice(product.getCurrentPrice()-dis);
                product.setDiscount(product.getDiscount()+discount.getdRete());

                historyRepository.save(history);
                productRepository.save(product);
            }
        }
    }
    @Scheduled(cron = " 59 59 23 * * *")
    public void getEndCampaign(){
        List<Object[]>campaigns=campaignRepository.getEndCampaign();
        for (Object[] objects:campaigns){
            Campaign campaign=campaignRepository.findById((int)objects[0]).get();
            List<Discount>discounts=campaign.getDiscounts();
            for (Discount discount:discounts){
                Product product=productRepository.findById(discount.getProduct().getpId()).get();

                History oldhistory=historyRepository.getOldHistory(product.getpId(),campaign.getStartDate());
                History history=new History();
                history.setPrice(product.getCurrentPrice());
                history.setDiscount(product.getDiscount());
                history.setLocalDate(campaign.getEndDate());
                history.setProduct(product);
                product.setDiscount(oldhistory.getDiscount());
                product.setCurrentPrice(oldhistory.getPrice());

                historyRepository.save(history);
                productRepository.save(product);
            }
            System.out.println("cam");
        }
    }
}
