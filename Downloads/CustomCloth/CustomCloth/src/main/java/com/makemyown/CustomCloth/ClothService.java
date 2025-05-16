package com.makemyown.CustomCloth;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService {

    @Autowired
    private ClothRepository clothRepository;

    public List<Cloth> getAllClothes() {
        return clothRepository.findAll();
    }

    public Cloth saveCloth(Cloth cloth) {
        return clothRepository.save(cloth);
    }

    public Cloth getClothById(Long id) {
        return clothRepository.findById(id).orElse(null);
    }

    public void deleteCloth(Long id) {
        clothRepository.deleteById(id);
    }
}
