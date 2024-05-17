package com.example.backend2.service;

import com.example.backend2.Artwork;
import com.example.backend2.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService {
    @Autowired
    private ArtworkRepository artworkRepository;

    public List<Artwork> findAll() {
        return artworkRepository.findAll();
    }

    public Artwork findById(Long id) {
        return artworkRepository.findById(id).orElse(null);
    }

    public Artwork save(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public void deleteById(Long id) {
        artworkRepository.deleteById(id);
    }
}
