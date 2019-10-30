package com.roguethree.gymchampionexerciseap.appBootstraper;

import com.roguethree.gymchampionexerciseap.model.*;
import com.roguethree.gymchampionexerciseap.repository.*;
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
    private final EquipmentRepository equipmentRepository;
    private final BodyPositionRepository bodyPositionRepository;
    private final PushPullSchemeRepository pushPullSchemeRepository;

    public DbBootstraper(BodyPartRepository bodyPartRepository,
                         ExerciseRepository exerciseRepository,
                         MuscleRepository muscleRepository, EquipmentRepository equipmentRepository,
                         BodyPositionRepository bodyPositionRepository,
                         PushPullSchemeRepository pushPullSchemeRepository) {
        this.bodyPartRepository = bodyPartRepository;
        this.exerciseRepository = exerciseRepository;
        this.muscleRepository = muscleRepository;
        this.equipmentRepository = equipmentRepository;
        this.bodyPositionRepository = bodyPositionRepository;
        this.pushPullSchemeRepository = pushPullSchemeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){

        // Body Part initialization

        Optional<BodyPart> armsBPOptional = bodyPartRepository.findByName("arms");
        if(!armsBPOptional.isPresent()){
            throw new RuntimeException("No such body part in data base");
        }

        Optional<BodyPart> foreArmsBPOptional = bodyPartRepository.findByName("forearms");

        Optional<BodyPart> shouldersArmsBPOptional = bodyPartRepository.findByName("shoulders");

        Optional<BodyPart> neckBPOptional = bodyPartRepository.findByName("neck");

        Optional<BodyPart> backBPOptional = bodyPartRepository.findByName("back");

        Optional<BodyPart> chestBPOptional = bodyPartRepository.findByName("chest");

        Optional<BodyPart> absBPOptional = bodyPartRepository.findByName("abs");

        Optional<BodyPart> glutesBPOptional = bodyPartRepository.findByName("glutes");

        Optional<BodyPart> hamsBPOptional = bodyPartRepository.findByName("hams");

        Optional<BodyPart> quadsBPOptional = bodyPartRepository.findByName("quads");

        Optional<BodyPart> calvesBPOptional = bodyPartRepository.findByName("calves");

        //Equipment init

        Optional<Equipment> dumbbellEquipmentOptional = equipmentRepository.findByEquipmentName("dumbbell");
        if(!dumbbellEquipmentOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }
        Optional<Equipment> barbellEquipmentOptional = equipmentRepository.findByEquipmentName("barbell");
        if(!barbellEquipmentOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }
        Optional<Equipment> kattlebellEquipmentOptional = equipmentRepository.findByEquipmentName("kattlebell");
        if(!kattlebellEquipmentOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }
        Optional<Equipment> noEquipmentOptional = equipmentRepository.findByEquipmentName("no_equipment");
        if(!noEquipmentOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }

        // Body position init

        Optional<BodyPosition> seatedBodyPosOptional =
                bodyPositionRepository.findByBodyPositionName("seated");
        if(!seatedBodyPosOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }
        Optional<BodyPosition> seatedBackSuportedBodyPosOptional =
                bodyPositionRepository.findByBodyPositionName("seated_back_supported");
        if(!seatedBackSuportedBodyPosOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }
        Optional<BodyPosition> standingBodyPosOptional =
                bodyPositionRepository.findByBodyPositionName("standing");
        if(!standingBodyPosOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }

        // Push pull scheme init

        Optional<PushPullScheme> pullSchemeOptional = pushPullSchemeRepository.findByPpSchemeName("pull");
        if(!pullSchemeOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }
        Optional<PushPullScheme> pushSchemeOptional = pushPullSchemeRepository.findByPpSchemeName("push");
        if(!pushSchemeOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }
        Optional<PushPullScheme> compoundSchemeOptional = pushPullSchemeRepository.findByPpSchemeName("compound");
        if(!compoundSchemeOptional.isPresent()){
            throw new RuntimeException("No such equipment id data base");
        }


        // Muscles init

        Optional<Muscle> bicepsLHMusclesOptional = muscleRepository.findByName("biceps_long_head");
        if(!bicepsLHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }
        muscleRepository.save(bicepsLHMusclesOptional.get());

        Optional<Muscle> bicepsSHMusclesOptional = muscleRepository.findByName("biceps_short_head");
        if(!bicepsSHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> tricpsLHMusclesOptional = muscleRepository.findByName("triceps_long_head");
        if(!tricpsLHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> tricpsLatHMusclesOptional = muscleRepository.findByName("triceps. lateral head");
        if(!tricpsLatHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> tricpsMHMusclesOptional = muscleRepository.findByName("triceps. medial head");
        if(!tricpsMHMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> forearmsFlexMusclesOptional = muscleRepository.findByName("forearms. flexors");
        if(!forearmsFlexMusclesOptional.isPresent()){
            throw new RuntimeException("No such muscle in data base");
        }

        Optional<Muscle> forearmsExtMusclesOptional = muscleRepository.findByName("forearms. extensors");
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
        dumbbellBicepsCurlStanding.setEquipment(dumbbellEquipmentOptional.get());
        dumbbellBicepsCurlStanding.setPushPullScheme(pullSchemeOptional.get());
        dumbbellBicepsCurlStanding.setBodyPosition(seatedBodyPosOptional.get());

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
