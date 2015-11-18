import junit.framework.TestCase;
import org.junit.Test;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    
    
    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }
    
    // Test for nonequality
    public void testNonEquality2() {
        assertFalse(new Rational(2,3).equals(new Integer(9)));
    }
    
    // Test for nonequality
    public void testNonEquality3() {
        assertFalse(new Rational(2,3).equals(null));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }
    
    //TODO: test empty argument in new
    
    //******************** Addition *********************
    public void testAddition2pos(){
        Rational op1 = new Rational(3,8);
        Rational op2 = new Rational(6,8);

        Rational sum = op2.plus(op1);
        assertTrue(sum.equals(new Rational(9,8) ) );
    }
    
    public void testAddition2pos2(){
        Rational op1 = new Rational(-3,-8);
        Rational op2 = new Rational(6,8);
        
        Rational sum = op2.plus(op1);
        assertTrue(sum.equals(new Rational(9,8) ) );
    }
    
    public void testAdditionNegNum(){
        Rational op1 = new Rational(-3,8);
        Rational op2 = new Rational(-6,8);
        
        Rational sum = op2.plus(op1);
        assertTrue(sum.equals(new Rational(-9,8) ) );
    }
    
    public void testAdditionNegDen(){
        Rational op1 = new Rational(3,-8);
        Rational op2 = new Rational(6,-8);
        
        Rational sum = op2.plus(op1);
        assertTrue(sum.equals(new Rational(-9,8) ) );
    }

    public void testAdditionNegNumNegDen(){
        Rational op1 = new Rational(3,-8);
        Rational op2 = new Rational(-6,8);
        
        Rational sum = op2.plus(op1);
        assertTrue(sum.equals(new Rational(-9,8) ) );
    }
    
    public void testAddition1neg1pos(){
        Rational op1 = new Rational(-3,8);
        Rational op2 = new Rational(7,8);
        
        Rational sum = op2.plus(op1);
        assertTrue(sum.equals(new Rational(4,8) ) );
    }
    
    public void testAddition1neg1zero(){
        Rational op1 = new Rational(-3,8);
        Rational op2 = new Rational(0,8);
        
        Rational sum = op2.plus(op1);
        assertTrue(sum.equals(new Rational(-3,8) ) );
    }
    
    //******************** Multiplication *********************
    public void testMultiplication(){// mult 2 negs, 1 neg and pos, 0
        Rational op1 = new Rational(3,8);
        Rational op2 = new Rational(6,8);

        Rational product = op2.times(op1);
        assertTrue(product.equals(new Rational(9,32) ) );
    }
    
    public void testMultiplication2(){
        Rational op1 = new Rational(-3,-8);
        Rational op2 = new Rational(6,8);
        
        Rational product = op2.times(op1);
        assertTrue(product.equals(new Rational(9,32) ) );
    }
   
    public void testMultNegNum(){
        Rational op1 = new Rational(-3,8);
        Rational op2 = new Rational(-6,8);
        
        Rational product = op2.times(op1);
        assertTrue(product.equals(new Rational(9,32) ) );
    }

    public void testMultNegDen(){
        Rational op1 = new Rational(3,-8);
        Rational op2 = new Rational(6,-8);
        
        Rational product = op2.times(op1);
        assertTrue(product.equals(new Rational(9,32) ) );
    }
    
    public void testMultNegNumNegDen(){
        Rational op1 = new Rational(-3,8);
        Rational op2 = new Rational(6,-8);
        
        Rational product = op2.times(op1);
        assertTrue(product.equals(new Rational(9,32) ) );
        
    }
    
    public void testMult1Neg1Pos(){
        Rational op1 = new Rational(3,8);
        Rational op2 = new Rational(6,-8);
        
        Rational product = op2.times(op1);
        assertTrue(product.equals(new Rational(-9,32) ) );
        
    }
    
    public void testMult1Neg1Zero(){
        Rational op1 = new Rational(-3,8);
        Rational op2 = new Rational(0,8);
        
        Rational product = op2.times(op1);
        assertTrue(product.equals(new Rational(0,32) ) );
    }
    
    //******************** Subtraction ************************
    public void testSubtraction(){  //sub 2 negs, sub 1 pos from neg and vice versa, 0
        Rational op1 = new Rational(5,8);
        Rational op2 = new Rational(6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(1,8) ) );
    }
    
    public void testSubtraction2(){
        Rational op1 = new Rational(-5,-8);
        Rational op2 = new Rational(6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(1,8) ) );
    }

    public void testSubNegNum(){
        Rational op1 = new Rational(-5,8);
        Rational op2 = new Rational(-6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(-1,8) ) );
    }

    public void testSubNegDen(){
        Rational op1 = new Rational(5,-8);
        Rational op2 = new Rational(6,-8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(-1,8) ) );
    }
    
    public void testSubNegNumNegDen(){
        Rational op1 = new Rational(5,-8);
        Rational op2 = new Rational(-6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(-1,8) ) );
    }
    
    public void testSubNegFromPos(){
        Rational op1 = new Rational(-5,8);
        Rational op2 = new Rational(6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(11,8) ) );
    }
    
    public void testSubNegFromPos2(){
        Rational op1 = new Rational(5,-8);
        Rational op2 = new Rational(6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(11,8) ) );
    }
    
    public void testSubPosFromNeg(){
        Rational op1 = new Rational(5,8);
        Rational op2 = new Rational(-6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(-11,8) ) );
    }
    
    public void testSubPosFromNeg2(){
        Rational op1 = new Rational(5,8);
        Rational op2 = new Rational(6,-8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(-11,8) ) );
    }
    
    public void testSubZeroFromNeg(){
        Rational op1 = new Rational(0,8);
        Rational op2 = new Rational(-6,8);
        
        Rational difference = op2.minus(op1);
        assertTrue(difference.equals(new Rational(-6,8) ) );
    }
    
    //********************** Division ************************
    public void testDivision(){
        Rational op1 = new Rational(5,8);
        Rational op2 = new Rational(6,8);
        
        Rational quotient = op2.divides(op1);
        assertTrue(quotient.equals(new Rational(6,5) ) );
    }
    
    public void testDivision2(){
        Rational op1 = new Rational(-5,-8);
        Rational op2 = new Rational(6,8);
        
        Rational quotient = op2.divides(op1);
        assertTrue(quotient.equals(new Rational(6,5) ) );
    }
    
    public void testDivBy0(){
        Rational op1 = new Rational(0,8);
        Rational op2 = new Rational(6,8);
        
        Rational quotient = op2.divides(op1);
        assertTrue(quotient.equals(new Rational(48,0) ) );
    }
    
    public void testDivNegByPos(){
        Rational op1 = new Rational(1,4);
        Rational op2 = new Rational(-1,2);
        
        Rational quotient = op2.divides(op1);
        assertTrue(quotient.equals(new Rational(-2,1) ) );
    }
    
    public void testDivPosByNeg(){
        Rational op1 = new Rational(-1,4);
        Rational op2 = new Rational(1,2);
        
        Rational quotient = op2.divides(op1);
        assertTrue(quotient.equals(new Rational(-2,1) ) );
    }
    
    //********************** Less Than ************************
    public void testLessThan(){ //test true, false, equal, and 0, neg and 0
        Rational op1 = new Rational(5,8);
        Rational op2 = new Rational(6,8);
        boolean result;
        
        result = op2.isLessThan(op1);
        assertEquals(result, false);
    }
    
    public void testLessThanFalse(){
        Rational op1 = new Rational(7,8);
        Rational op2 = new Rational(0,8);
        boolean result;
        
        result = op2.isLessThan(op1);
        assertEquals(result, true);
    }
    
    public void testLessThanWhenEqual(){
        Rational op1 = new Rational(6,8);
        Rational op2 = new Rational(6,8);
        boolean result;
        
        result = op2.isLessThan(op1);
        assertEquals(result, false);
    }
    
    public void testLessThan0(){
        Rational op1 = new Rational(0,8);
        Rational op2 = new Rational(-1,8);
        boolean result;
        
        result = op2.isLessThan(op1);
        assertEquals(result, true);
    }
    
    
    public void testLessThan0_2(){
        Rational op1 = new Rational(0,8);
        Rational op2 = new Rational(1,-8);
        boolean result;
        
        result = op2.isLessThan(op1);
        assertEquals(result, true);
    }
    
    //********************** Absolute ************************
    public void testAbs(){// pos and 0 num and neg den
        Rational op1 = new Rational(-3,5);
        Rational result = op1.abs();
        
        assertTrue(result.equals(new Rational(3,5) ));
    }
    
    public void testAbsNegDen(){
        Rational op1 = new Rational(3,-5);
        Rational result = op1.abs();
        
        assertTrue(result.equals(new Rational(3,5) ));
    }

    public void testAbs0    (){
        Rational op1 = new Rational(0,-5);
        Rational result = op1.abs();
        
        assertTrue(result.equals(new Rational(0,5) ));
    }
    //********************** toString ************************
    public void testToString(){
        Rational number = new Rational(7,23);
        String str = number.toString();
        
        assertEquals(str, "7/23");
    }
    
    public void testToStringNeg(){ //test negative
        Rational number = new Rational(-7,23);
        String str = number.toString();
        
        assertEquals(str, "-7/23");
    }
    
    public void testTolerance(){
        Rational test = new Rational(1,1);
        test.setTolerance(new Rational(2,576));
        assertEquals(test.getTolerance(), new Rational(2,576));
    }
    
    @Test(expected = IllegalArgumentToSquareRootException.class)
    public void testIllegalArgumentToSquareRootException(){
        Rational nullRational = new Rational(0, -1);
        try{
            System.out.println("Root of nullRational is " + nullRational.root());
        }
        catch(IllegalArgumentToSquareRootException e){
            
        }
    }
    
    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}

