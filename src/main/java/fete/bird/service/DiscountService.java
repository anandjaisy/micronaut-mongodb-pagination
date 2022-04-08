package fete.bird.service;

import fete.bird.entity.Discount;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static fete.bird.specification.Specifications.discountCodeEquals;

@Singleton
public record DiscountService(IDiscountRepository iDiscountRepository) implements IDiscountService{

    public Flux<Page<Discount>> find(String discountCode) {
        var test = Mono.from(iDiscountRepository.findAll(discountCodeEquals(discountCode), Pageable.from(0, 2))).block();
        return iDiscountRepository.findAll(discountCodeEquals(discountCode), Pageable.from(0, 2));
    }

    @Override
    public Mono<Discount> create(Discount discount) {
        return iDiscountRepository.save(discount);
    }
}
