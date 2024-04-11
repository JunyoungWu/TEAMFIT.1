package TeamFit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExerciseCart implements ExerciseInterface {
	public ArrayList<Exercise>  exerciselist = new ArrayList<Exercise>();
	public static int exerciseCount = 0;  //
	
	
			

	public void saveExerciseData(String userName,String pNum) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(userName+"_"+pNum + "_Exercise.txt"));
            for (Exercise exercise : exerciselist) {
                writer.write(exercise.getClassCode() + "," + exercise.getName() + "," + exercise.getLocation() + "," + exercise.getDate() + "," + exercise.getMemNum()+","+exercise.getTeacherName()+","+exercise.getPrice());
                writer.newLine(); 
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 사용자의 운동 정보를 불러오는 메서드
    public void loadExerciseData(String userName, String pNum) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userName+"_"+pNum + "_Exercise.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String code = parts[0];
                String name = parts[1];
                String location = parts[2];
                String date = parts[3];
                int memnum = Integer.parseInt(parts[4]);
                String teachername = parts[5];
                int price = Integer.parseInt(parts[6]);
              
                exerciselist.add(new Exercise(code, name, location, date, memnum,teachername,price));
            }
            reader.close();
        }catch(FileNotFoundException e) {
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	@Override
	public void printExerciseList(ArrayList<Exercise> exerciselist) {
		for (int i  = 0; i<exerciselist.size();i++) {
			Exercise exercise = exerciselist.get(i);
			System.out.println(exercise.getClassCode());
			System.out.println(exercise.getName());
			System.out.println(exercise.getLocation());
			System.out.println(exercise.getDate());
			System.out.println(exercise.getMemNum());
			System.out.println(exercise.getTeacherName());
			System.out.println(exercise.getPrice());
			
			
		}
	}

	@Override
	public void insertExercise(Exercise exercise) {
		if(exerciselist.contains(exercise)) {
			System.out.println();
			System.out.println("이미 신청한 항목입니다.");
			System.out.println();
		}
		else{
			System.out.println();
		exerciselist.add(exercise);
		exerciseCount=exerciselist.size();	
			System.out.println();
		
		}
		
	}

	@Override
	public void removeCart(String classCode) {
	  
	    for (Iterator<Exercise> iterator = exerciselist.iterator(); iterator.hasNext();) {
	        Exercise exercise = iterator.next();
	        if (exercise.getClassCode().equals(classCode)) {
	            iterator.remove(); 
	            System.out.println();
	            System.out.println("운동이 성공적으로 삭제되었습니다.");
	            System.out.println();
	            return; 
	        }
	    }
	  
	    System.out.println("해당 과목 코드에 해당하는 운동이 존재하지 않습니다.");
	}


	@Override
	public void delAllExercise() {
		exerciselist.clear();
		exerciseCount = 0;
		
	}
	public ArrayList<String> getExerciseCodes() {
        ArrayList<String> codes = new ArrayList<>();
        for (Exercise exercise : exerciselist) {
            codes.add(exercise.getClassCode());
        }
        return codes;
    }
	public void printCart() {
	    System.out.println("=========================================================================================================================================================");
	    System.out.printf("\t%-12s | %-12s | %-12s | %-12s | %-12s |\n", "강의코드", "이름", "장소", "날짜", "인원 수");
	  

	    for(int i = 0; i < exerciselist.size(); i++) {
	        System.out.printf("\t%-12s | %-12s | %-12s | %-12s | %-12s |\n",
	                exerciselist.get(i).getClassCode().substring(0, Math.min(exerciselist.get(i).getClassCode().length(), 12)),
	                exerciselist.get(i).getName().substring(0, Math.min(exerciselist.get(i).getName().length(), 12)),
	                exerciselist.get(i).getLocation().substring(0, Math.min(exerciselist.get(i).getLocation().length(), 12)),
	                exerciselist.get(i).getDate().substring(0, Math.min(exerciselist.get(i).getDate().length(), 12)),
	                exerciselist.get(i).getMemNum());
	    }
	    System.out.println("=========================================================================================================================================================");
	}


}
