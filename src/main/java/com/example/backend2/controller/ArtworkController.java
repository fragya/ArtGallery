package com.example.backend2.controller;

import com.example.backend2.Artwork;
import com.example.backend2.service.ArtworkService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtworkController {
    @Autowired
    private ArtworkService artworkService;

    @GetMapping("/artworks")
    public ModelAndView viewArtworks() {
        ModelAndView mav = new ModelAndView("artworks");
        mav.addObject("artworks", artworkService.findAll());
        return mav;
    }

    @GetMapping("/artworks/add")
    public ModelAndView addArtworkForm(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("addArtwork");
    }

    @PostMapping("/artworks/add")
    public String addArtwork(@RequestParam String title, @RequestParam String artist, @RequestParam String year, @RequestParam String imageUrl, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        Artwork newArtwork = new Artwork();
        newArtwork.setTitle(title);
        newArtwork.setArtist(artist);
        newArtwork.setYear(year);
        newArtwork.setImageUrl(imageUrl);
        artworkService.save(newArtwork);
        return "redirect:/dashboard";
    }

    @PostMapping("/artworks/delete")
    public String deleteArtwork(@RequestParam Long artworkId, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        artworkService.deleteById(artworkId);
        return "redirect:/dashboard";
    }

}
