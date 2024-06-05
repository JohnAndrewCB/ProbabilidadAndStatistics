package PolynomialRegression;

public class PRMain {

    public static void main(String[] args) {
        DataSetPolynomial myDS = new DataSetPolynomial();
        DiscretMathsPolynomial myDM = new DiscretMathsPolynomial();
        PolynomialRegression myPR = new PolynomialRegression();

        double[][] equisNorden = myDM.DeNOrden(myDS.getX());

        double[][] transpuestaDeEquis = myDM.TranspuestaX(equisNorden);

        double[][] transPorNormal = myDM.MultiplicacionMatricial(transpuestaDeEquis, equisNorden);

        double[][] inversaTransPorNormal = myDM.MatrizInversa(transPorNormal);

        double[][] normalDeY = myDM.NormalDeY(myDS.getY());

        double[][] transpuestaPorY = myDM.TranspuestaPorY(transpuestaDeEquis, normalDeY);

        double[][] betas = myPR.Betas(inversaTransPorNormal, transpuestaPorY); //dimensiones: m x 1

        double[] y = myPR.Predicciones(myDS.getDesco(), betas);

        double correlacion = myDM.Correlacion(myDS.getY(), myDS.getX());
        double determinacion = myDM.Determinacion(myDS.getY());

        myPR.ecuacionRegresssion(equisNorden, betas);

        myDM.ImprimirBetas(betas); System.out.println("\n");

        myDM.ImprimirPredicciones(y); System.out.println("\n");

        System.out.println("Coeficiente de correlacion (r): "+correlacion); //R
        System.out.println("Coeficiente de determinacion (r^2): "+determinacion); //R^2
    }
}