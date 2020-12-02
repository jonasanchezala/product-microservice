package co.edu.javeriana.toures.product.repositories;

import co.edu.javeriana.toures.product.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJPARepository extends JpaRepository<Product, Integer>  {

    @Query("FROM Product WHERE showName like %:search% AND category like %:search% order by 1 asc")
    List<Product> findByProductPage(String search, Pageable pageable);

    @Query("FROM Product WHERE id = ?1")
    List<Product> findByProductCodigo(int search, Pageable pageable);
}
/*
@Query(value = "select * from (select (@rowid\\:=@rowid+1) as RN, u.* from product u, (SELECT @rowid\\:=0) as init where  show_name = ?1) as total"+
        "where RN between ?#{#pageable.offset-1} and ?#{#pageable.offset + #pageable.pageSize}",
        countQuery = "SELECT count(*) FROM product WHERE show_name = ?1",
        nativeQuery = true)*/
//ISNUMERIC(c.textOrNumber ) = 1