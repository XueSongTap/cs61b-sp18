public class NBody {


    public static double readRadius(String file){
        In in = new In(file);

        int n = in.readInt();
        double r = in.readDouble();

        return r;
    }

    public static Planet[] readPlanets(String file){
        In in = new In(file);
        Planet[] allPlanets = new Planet[5];

        /* Skip the first two lines */
        in.readLine();
        in.readLine();

        for(int i=0; i<5; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return allPlanets;

        
    }
}
