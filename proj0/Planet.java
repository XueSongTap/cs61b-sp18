public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;


    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double sum = (p.xxPos - xxPos) * (p.xxPos - xxPos) + (p.yyPos - yyPos) * (p.yyPos - yyPos);


        return Math.sqrt(sum);

    }


    public double calcForceExertedBy(Planet p){
        double ds = this.calcDistance(p);

        return G * this.mass * p.mass / (ds * ds);
    }

    public double calcForceExertedByX(Planet p){
        double ds = this.calcDistance(p);
        double f = this.calcForceExertedBy(p);


        return f * (p.xxPos - this.xxPos) / ds;
    }
    public double calcForceExertedByY(Planet p){
        double ds = this.calcDistance(p);
        double f = this.calcForceExertedBy(p);


        return f * (p.yyPos - this.yyPos) / ds;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double nf = 0.0;

        int n = allPlanets.length;
        for (int i = 0; i < n; i ++){
            if (this != allPlanets[i]){
                nf += this.calcForceExertedByX(allPlanets[i]);
            }
        }

        return nf;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double nf = 0.0;

        int n = allPlanets.length;
        for (int i = 0; i < n; i ++){
            if (this != allPlanets[i]){
                nf += this.calcForceExertedByY(allPlanets[i]);
            }

        }

        return nf;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;

        this.xxPos += xxVel * dt;
        this.yyPos += yyVel * dt;
    }

    public void draw(){

        StdDraw.picture(this.xxPos,this.yyPos, "./images/" + this.imgFileName);
    }
}



