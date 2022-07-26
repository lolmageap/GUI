package assembles;

public class Star {
   int score1 = 1;
   int score2 = 2;
   int score3 = 3;
   int score4 = 4;
   int score5 = 5;
   int sum = 0;
   float dotted = 0.0f;
   String star_ranking = "";
   static int stars = 0;
   static int count = 0;
   
   public void return_score(int a) {
      
      if(score1 == a) {
         stars += score1;
         count++;
      }
      else if(score2 == a) {
         stars += score2;
         count++;
      }
      else if(score3 == a) {
         stars += score3;
         count++;
      }
      else if(score4 == a) {
         stars += score4;
         count++;
      }
      else if(score5 == a) {
         stars += score5;
         count++;
      }
      else {
         stars += 0;
         count++;
      }
      
   }
   
   public float return_star() {
      

      
      dotted = ((float)stars)/((float)count) ;
      
      String str = String.format("%.01f", dotted);
      dotted = Float.valueOf(str);
      
      return dotted;
   }
   
   public String star_rank() {
      
      if(dotted < 2 && dotted >= 1) {
         star_ranking = "¡Ú";
      }
      else if(dotted < 3 && dotted >= 2) {
         star_ranking = "¡Ú¡Ú";
      }
      else if(dotted < 4 && dotted >= 3) {
         star_ranking = "¡Ú¡Ú¡Ú";
      }
      else if(dotted < 5 && dotted >= 4) {
         star_ranking = "¡Ú¡Ú¡Ú¡Ú";
      }
      else {
         star_ranking = "¡Ú¡Ú¡Ú¡Ú¡Ú";
      }
      
      return star_ranking;
   }
   
}