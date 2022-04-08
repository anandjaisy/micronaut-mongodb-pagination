package fete.bird.service;

import fete.bird.entity.Discount;
import io.micronaut.data.model.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IDiscountService {
    Flux<Page<Discount>> find(String discountCode);
    Mono<Discount> create(Discount discount);
}
