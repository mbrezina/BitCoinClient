package cz.burj.bitcoin.controller;

import cz.burj.bitcoin.entity.Data;
import cz.burj.bitcoin.repository.RateRepository;
import cz.burj.bitcoin.service.ApiCall;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    private RateRepository rateRepository;
    private ApiCall call;

    public MainController(RateRepository rateRepository, ApiCall call) {
        this.rateRepository = rateRepository;
        this.call = call;
    }

    @RequestMapping("/")
    public ModelAndView showRate() throws IOException {
        Data rateToSave = call.doGetRequest("https://coinmate.io/api/ticker?currencyPair=BTC_CZK");

        if (rateRepository.findByDate(rateToSave.getDate()) == null) {
            rateRepository.save(rateToSave);
        }
        ModelAndView dataHolder = new ModelAndView("index");
        List<Data> listRates = rateRepository.findLatest7();

        dataHolder.addObject("actualRate", rateToSave);
        dataHolder.addObject("rateHistory", listRates);
        return dataHolder;
    }

    @RequestMapping("api/v1/dataForGraph")
    public @ResponseBody
    List<Data> sendHistoricalRates() {
        return rateRepository.findLatest7();
    }
}



