package com.makemyown.CustomCloth;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothController {

    @Autowired
    private ClothService clothService;

    @GetMapping
    public List<Cloth> getAllClothes() {
        return clothService.getAllClothes();
    }

    @PostMapping
    public Cloth createCloth(@RequestBody Cloth cloth) {
        return clothService.saveCloth(cloth);
    }

    @GetMapping("/{id}")
    public Cloth getClothById(@PathVariable Long id) {
        return clothService.getClothById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCloth(@PathVariable Long id) {
        clothService.deleteCloth(id);
    }
}
