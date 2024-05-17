package com.example.backend2.repository;

import com.example.backend2.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    // Burada gerektiğinde çeşitli kriterlere göre eserleri getirecek metotlar tanımlayabilirsiniz
}
