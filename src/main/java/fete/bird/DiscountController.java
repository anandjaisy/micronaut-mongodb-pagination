package fete.bird;

import fete.bird.entity.Discount;
import fete.bird.service.IDiscountService;
import io.micronaut.data.model.Page;
import io.micronaut.http.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/discount")
public class DiscountController {
    private final IDiscountService iDiscountService;

    public DiscountController(IDiscountService iDiscountService) {
        this.iDiscountService = iDiscountService;
    }

    @Get(uri="/")
    public Flux<Page<Discount>> find() {
        return iDiscountService.find("Discout-code");
    }

    @Post(uri="/")
    public Mono<Discount> post(Discount discount) {
        return iDiscountService.create(discount);
    }
}