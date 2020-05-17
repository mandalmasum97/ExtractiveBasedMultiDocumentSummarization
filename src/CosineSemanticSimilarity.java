
public class CosineSemanticSimilarity {
    public double cosineSimilarity(double[] docVector1, double[] docVector2) {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double docVector3=0.0;
        double docVector4=0.0;
        double cosineSimilarity = 0.0;
        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
       
        	dotProduct += docVector1[i] * docVector2[i];  //a.b
            docVector3=docVector1[i]*docVector1[i];
            docVector4=docVector2[i]*docVector2[i];
        	magnitude1 += docVector3;  //(a^2)
            magnitude2 += docVector4; //(b^2) 
        }

        magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)
        docVector1=null;
        docVector2=null;
        if (magnitude1 != 0.0 && magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }
}