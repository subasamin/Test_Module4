package com.example.test_module4.service;

import com.example.test_module4.model.Coupon;
import com.example.test_module4.repository.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CouponService implements ICouponService {

    @Autowired
    private ICouponRepository couponRepository;

    @Override
    public Iterable<Coupon> findAll() {
        return couponRepository.findAll();
    }

    @Override
    public Optional<Coupon> findById(Integer id) {
        return couponRepository.findById(id);
    }

    @Override
    public Coupon save(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public void delete(Integer id) {
        couponRepository.deleteById(id);
    }
}
