package Service;

import Comparator.*;
import Employee.Chef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static FileManager.FileService.writeWithAppend;

public class ChefService {

    public void writeFullNamesSortedBySpecialization(ArrayList<Chef> chefs) throws IOException {
        writeWithAppend("./FileService\\chefOutput.txt","Method #1\n");
        Collections.sort(chefs,new SpecializationComparator());
        for(Chef chef: chefs) {
            writeWithAppend("./FileService\\chefOutput.txt",chef.getFullName()+"\n");
        }
    }

    public void writeMostExperiencedChef(ArrayList<Chef> chefs) throws  IOException{
        writeWithAppend("./FileService\\chefOutput.txt","Method #2\n");
        writeWithAppend("./FileService\\chefOutput.txt", Collections.max(chefs,new ExperienceComparator()).toString()+"\n");
    }

    public void sortChefsByMichelinStars(ArrayList<Chef> chefs) throws IOException {
        writeWithAppend("./FileService\\chefOutput.txt","Method #3\n");
        Collections.sort(chefs, new MichelinStarsComparator());
        for(Chef chef:chefs) {
            writeWithAppend("./FileService\\chefOutput.txt", chef.toString()+"\n");
        }
    }

    public void sortFemaleChefsByCuisine(ArrayList<Chef> chefs) throws IOException {
        writeWithAppend("./FileService\\chefOutput.txt","Method #4\n");
        Collections.sort(chefs, new CuisineComparator());
            for(Chef chef: chefs) {
                if(chef.getGender() == 'f') {
                    writeWithAppend("./FileService\\chefOutput.txt", chef.toString()+"\n");
                }
            }
    }

}

