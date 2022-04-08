package fete.bird.service;

import com.mongodb.lang.Nullable;
import fete.bird.entity.Discount;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;
import io.micronaut.data.repository.jpa.reactive.ReactorJpaSpecificationExecutor;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;

@MongoRepository
public interface IDiscountRepository extends ReactorCrudRepository<Discount, ObjectId>, ReactorJpaSpecificationExecutor<Discount> {
    @NonNull
    Flux<Page<Discount>> findAll(@Nullable PredicateSpecification<Discount> spec, Pageable pageable);
}
