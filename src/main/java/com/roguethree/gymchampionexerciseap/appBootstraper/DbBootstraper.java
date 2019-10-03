package com.roguethree.gymchampionexerciseap.appBootstraper;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.Muscle;
import com.roguethree.gymchampionexerciseap.model.enums.BodyPosition;
import com.roguethree.gymchampionexerciseap.model.enums.Equipment;
import com.roguethree.gymchampionexerciseap.model.enums.PushPullScheme;
import com.roguethree.gymchampionexerciseap.repository.BodyPartRepository;
import com.roguethree.gymchampionexerciseap.repository.ExerciseRepository;
import com.roguethree.gymchampionexerciseap.repository.MuscleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DbBootstraper implements CommandLineRunner {

    private final BodyPartRepository bodyPartRepository;
    private final ExerciseRepository exerciseRepository;
    private final MuscleRepository muscleRepository;

    public DbBootstraper(BodyPartRepository bodyPartRepository,
                         ExerciseRepository exerciseRepository,
                         MuscleRepository muscleRepository) {
        this.bodyPartRepository = bodyPartRepository;
        this.exerciseRepository = exerciseRepository;
        this.muscleRepository = muscleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){

        // Body Part initialization

        Optional<BodyPart> armsBPOptional = bodyPartRepository.findByName("Arms");
        if(!armsBPOptional.isPresent()){
            throw new RuntimeException("No such body part in data base");
        }
//        exerciseRepository.save(armsBPOptional.get());

        Optional<BodyPart> foreArmsBPOptional = bodyPartRepository.findByName("Forearms");

        Optional<BodyPart> shouldersArmsBPOptional = bodyPartRepository.findByName("Shoulders");

        Optional<BodyPart> neckBPOptional = bodyPartRepository.findByName("Neck");

        Optional<BodyPart> backBPOptional = bodyPartRepository.findByName("Back");

        Optional<BodyPart> chestBPOptional = bodyPartRepository.findByName("Chest");

        Optional<BodyPart> absBPOptional = bodyPartRepository.findByName("Abs");

        Optional<BodyPart> glutesBPOptional = bodyPartRepository.findByName("Glutes");

        Optional<BodyPart> hamsBPOptional = bodyPartRepository.findByName("Hams");

        Optional<BodyPart> quadsBPOptional = bodyPartRepository.findByName("Quads");

        Optional<BodyPart> calvesBPOptional = bodyPartRepository.findByName("Calves");

        // Muscles init

        Optional<Muscle> bicepsLHMusclesOptional = muscleRepository.findByName("Biceps. Long Head");
        if(!bicepsLHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }
        muscleRepository.save(bicepsLHMusclesOptional.get());

        Optional<Muscle> bicepsSHMusclesOptional = muscleRepository.findByName("Biceps. Short Head");
        if(!bicepsSHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> tricpsLHMusclesOptional = muscleRepository.findByName("Triceps. Long Head");
        if(!tricpsLHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> tricpsLatHMusclesOptional = muscleRepository.findByName("Triceps. Lateral Head");
        if(!tricpsLatHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> tricpsMHMusclesOptional = muscleRepository.findByName("Triceps. Medial Head");
        if(!tricpsMHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> forearmsFlexMusclesOptional = muscleRepository.findByName("Forearms. Flexors");
        if(!forearmsFlexMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> forearmsExtMusclesOptional = muscleRepository.findByName("Forearms. Extensors");
        if(!forearmsExtMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> deltsAHMusclesOptional = muscleRepository.findByName("Deltoids. Anterior Head");
        if(!deltsAHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> deltsMHMusclesOptional = muscleRepository.findByName("Deltoids. Medial Head");
        if(!deltsMHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> deltsPHMusclesOptional = muscleRepository.findByName("Deltoids. Posterior Head");
        if(!deltsPHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> trapesiusUpMusclesOptional = muscleRepository.findByName("Upper Trapesius");
        if(!trapesiusUpMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> trapesiusMiddMusclesOptional = muscleRepository.findByName("Middle Trapesius");
        if(!trapesiusMiddMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> trapesiusLowMusclesOptional = muscleRepository.findByName("Lower Trapesius");
        if(!trapesiusLowMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> latissimusDorsiMusclesOptional = muscleRepository.findByName("Latissimus Dorsi");
        if(!latissimusDorsiMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> upperChestMusclesOptional = muscleRepository.findByName("Upper Chest");
        if(!upperChestMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> middleChestMusclesOptional = muscleRepository.findByName("Middle Chest");
        if(!middleChestMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> lowerChestMusclesOptional = muscleRepository.findByName("Lower Chest");
        if(!lowerChestMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> absMusclesOptional = muscleRepository.findByName("Abs");
        if(!absMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> gluteusMusclesOptional = muscleRepository.findByName("Gluteus");
        if(!gluteusMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> hamstringsMusclesOptional = muscleRepository.findByName("Hamstrings");
        if(!hamstringsMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> quadsMusclesOptional = muscleRepository.findByName("Quads");
        if(!quadsMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> calvesMusclesOptional = muscleRepository.findByName("Calves");
        if(!calvesMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Exercise dumbbellBicepsCurlStanding = new Exercise();
        dumbbellBicepsCurlStanding.setName("Dumbbell_BicepsCurl_Standing");
        dumbbellBicepsCurlStanding.setEquipment(Equipment.DUMBBELL);
        dumbbellBicepsCurlStanding.setPushPullScheme(PushPullScheme.PULL);
        dumbbellBicepsCurlStanding.setBodyPosition(BodyPosition.STANDING);

        Set<BodyPart> dumbbellBicepsCurlStandingBodyPartsSet = new HashSet<>();
        dumbbellBicepsCurlStandingBodyPartsSet.add(armsBPOptional.get());
        dumbbellBicepsCurlStanding.setBodyParts(dumbbellBicepsCurlStandingBodyPartsSet);

        Set<Muscle> dumbbellBicepsCurlStandingMuscleSet = new HashSet<>();
        dumbbellBicepsCurlStandingMuscleSet.add(bicepsLHMusclesOptional.get());
        dumbbellBicepsCurlStandingMuscleSet.add(bicepsSHMusclesOptional.get());
        dumbbellBicepsCurlStanding.setMuscles(dumbbellBicepsCurlStandingMuscleSet);
        exerciseRepository.save(dumbbellBicepsCurlStanding);


    }



}
