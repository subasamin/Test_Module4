package com.example.test_module4.controller;

import com.example.test_module4.model.Coupon;
import com.example.test_module4.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping
    public ModelAndView coupon(Model model) {
        ModelAndView modelAndView = new ModelAndView("/Coupon");
        modelAndView.addObject("coupons" , couponService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") int idDelete) {
        couponService.delete(idDelete);
        return "redirect:/coupon";
    }

    @GetMapping("/formCreate")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("/CreateCoupon");
        modelAndView.addObject("coupon", new Coupon());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(Coupon coupon) {
        ModelAndView modelAndView = new ModelAndView("/CreateCoupon");
        couponService.save(coupon);
        return modelAndView;
    }

    @GetMapping("/formUpdate")
    public ModelAndView formUpdate(@RequestParam("idUpdate" ) int idUpdate) {
        ModelAndView modelAndView = new ModelAndView("/UpdateCoupon");
        modelAndView.addObject("coupon", couponService.findById(idUpdate).get());
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView update(Coupon coupon) {
        ModelAndView modelAndView = new ModelAndView("/UpdateCoupon");
        couponService.save(coupon);
        return modelAndView;
    }
}
