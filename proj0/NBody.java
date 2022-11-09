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

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double r = readRadius(filename);
        Planet[] allPlanets = readPlanets(filename);
        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-r, r);
        StdDraw.picture(0,0,"./images/starfield.jpg");

        int n = allPlanets.length;

        for (int i = 0; i < n; i ++){
            Planet p = allPlanets[i];

            p.draw();
        }

        for (double time = 0; time < T; time +=dt){
            double[] xF = new double[n];
            double[] yF = new double[n];


            for (int i = 0; i < n; i ++){
                xF[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yF[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
            }

            for (int i = 0; i < n; i ++){
                allPlanets[i].update(dt, xF[i], xF[i]);
            }

            StdDraw.picture(0,0,"./images/starfield.jpg");
            for (int i = 0; i < n; i ++){
                allPlanets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < n; i ++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", allPlanets[i].xxPos, allPlanets[i].yyPos,
                    allPlanets[i].xxVel, allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }
    }
}
