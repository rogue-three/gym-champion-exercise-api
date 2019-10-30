package com.roguethree.gymchampionexerciseap.services.jpaServices;

import com.roguethree.gymchampionexerciseap.model.Equipment;
import com.roguethree.gymchampionexerciseap.repository.EquipmentRepository;
import com.roguethree.gymchampionexerciseap.services.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JpaEquipmentSevice implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public JpaEquipmentSevice(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Stream<Equipment> findAll() {
        return equipmentRepository.findAll().stream();
    }

    @Override
    public Optional<Equipment> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Equipment> findByName(String name) {
        return Optional.empty();
    }
}
