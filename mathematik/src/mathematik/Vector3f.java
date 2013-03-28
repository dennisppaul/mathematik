/*
 * Mathematik
 *
 * Copyright (C) 2012 Patrick Kochlik + Dennis Paul
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * {@link http://www.gnu.org/licenses/lgpl.html}
 *
 */
package mathematik;


import java.io.Serializable;
import java.util.Random;


public class Vector3f
        implements Cloneable, Serializable, Comparable<Vector3f>, Vectorf {

    private static final long serialVersionUID = -1021495605082676516L;

    /**
     * Utility for random
     */
    static final Random generator = new Random();

    /**
     * The x coordinate of the vector
     */
    public float x;

    /**
     * The y coordinate of the vector
     */
    public float y;

    /**
     * The z coordinate of the vector
     */
    public float z;

//    /**
//     * float array for returning an array representation of the vector
//     */
//    private float[] _myArrayRepresentation = new float[3];
    /**
     * threshold to maintain the minimal difference between two vectors before
     * they are almost the same
     */
    private static final float ALMOST_THRESHOLD = 0.001f;

    /**
     * Initializes a new vector. x, y, and z are set to zero.
     */
    public Vector3f() {
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
    }

    /**
     * Creates a new vector with the given coordinates. Inserted double values
     * are casted to floats
     *
     * @param theX int, float or double: x coord of the new vector
     * @param theY int, float or double: y coord of the new vector
     * @param theZ int, float or double: z coord of the new vector
     */
    public Vector3f(float theX, float theY, float theZ) {
        set(theX, theY, theZ);
    }

    public Vector3f(double theX, double theY, double theZ) {
        set(theX, theY, theZ);
    }

    public Vector3f(float theX, float theY) {
        set(theX, theY);
    }

    public Vector3f(double theX, double theY) {
        set(theX, theY);
    }

    public Vector3f(float[] theVector) {
        set(theVector);
    }

    public Vector3f(double[] theVector) {
        set(theVector);
    }

    public Vector3f(int[] theVector) {
        set(theVector);
    }

    public Vector3f(Vector3f theVector) {
        set(theVector);
    }

    public Vector3f(Vector2f theVector) {
        set(theVector);
    }

    public Vector3f(Vector3i theVector) {
        set(theVector);
    }

    public Vector3f(Vector2i theVector) {
        set(theVector);
    }

    public Vector3f(String theVector) {
        set(theVector);
    }

    public final Vector3f set(float theX, float theY, float theZ) {
        x = theX;
        y = theY;
        z = theZ;
        return this;
    }

    public final Vector3f set(double theX, double theY, double theZ) {
        x = (float) theX;
        y = (float) theY;
        z = (float) theZ;
        return this;
    }

    public final Vector3f set(float theX, float theY) {
        x = theX;
        y = theY;
        return this;
    }

    public final Vector3f set(double theX, double theY) {
        x = (float) theX;
        y = (float) theY;
        return this;
    }

    public final Vector3f set(float[] theVector) {
        x = theVector[0];
        y = theVector[1];
        z = theVector[2];
        return this;
    }

    public final Vector3f set(double[] theVector) {
        x = (float) theVector[0];
        y = (float) theVector[1];
        z = (float) theVector[2];
        return this;
    }

    public final Vector3f set(int[] theVector) {
        x = theVector[0];
        y = theVector[1];
        z = theVector[2];
        return this;
    }

    public final Vector3f set(Vector3f theVector) {
        x = theVector.x;
        y = theVector.y;
        z = theVector.z;
        return this;
    }

    public final Vector3f set(Vector2f theVector) {
        x = theVector.x;
        y = theVector.y;
        return this;
    }

    public final Vector3f set(Vector3i theVector) {
        x = theVector.x;
        y = theVector.y;
        z = theVector.z;
        return this;
    }

    public final Vector3f set(Vector2i theVector) {
        x = theVector.x;
        y = theVector.y;
        return this;
    }

    public final Vector3f set(String theVectorString) {
        theVectorString = theVectorString.replace("(", "");
        theVectorString = theVectorString.replace(")", "");
        theVectorString = theVectorString.replaceAll(" ", "");
        String[] myComponents = theVectorString.split(",");

        try {
            x = Float.parseFloat(myComponents[0]);
        } catch (Exception ex) {
        }
        try {
            y = Float.parseFloat(myComponents[1]);
        } catch (Exception ex1) {
        }
        try {
            z = Float.parseFloat(myComponents[2]);
        } catch (Exception ex2) {
        }
        return this;
    }

    public Vector3f add(Vector3f theVectorA, Vector3f theVectorB) {
        x = theVectorA.x + theVectorB.x;
        y = theVectorA.y + theVectorB.y;
        z = theVectorA.z + theVectorB.z;
        return this;
    }

    public Vector3f add(Vector3f theVector) {
        x += theVector.x;
        y += theVector.y;
        z += theVector.z;
        return this;
    }

    public Vector3f add(float theX, float theY) {
        x += theX;
        y += theY;
        return this;
    }

    public Vector3f add(float theX, float theY, float theZ) {
        x += theX;
        y += theY;
        z += theZ;
        return this;
    }

    public Vector3f sub(Vector3f theVectorA, Vector3f theVectorB) {
        x = theVectorA.x - theVectorB.x;
        y = theVectorA.y - theVectorB.y;
        z = theVectorA.z - theVectorB.z;
        return this;
    }

    public Vector3f sub(Vector3f theVector) {
        x -= theVector.x;
        y -= theVector.y;
        z -= theVector.z;
        return this;
    }

    /**
     * Use this method to negate a vector. The result of the negation is vector
     * with the same magnitude but opposite direction. Mathematically the
     * negation is the additive inverse of the vector. The sum of a value and
     * its additive inerse is always zero.
     *
     * @shortdesc Use this method to negate a vector.
     * @related scale ( )
     */
    public Vector3f negate() {
        scale(-1);
        return this;
    }

    /**
     * Use this method to scale a vector. To scale a vector each of its
     * coordinates is multiplied with the given scalar. The result is a vector
     * that is parallel with its origin, with a different length and possibly
     * opposite direction.<br>
     * You can also scale a vector with another vector, in this case each coord
     * of the vector is multiplied with related coord of the given vector.<br>
     * Another possibillity is to set and scale the vector, this means the
     * vector is set to the given vector multiplied with the given scalar.
     *
     * @param theScalar float or int: the value the vector is scaled with
     * @related divide ( )
     * @related negate ( )
     */
    public Vector3f scale(final float theScalar) {
        x *= theScalar;
        y *= theScalar;
        z *= theScalar;
        return this;
    }

    /**
     *
     * @param theVector Vector3f: vector with the value each coord is scaled
     * with
     */
    public Vector3f scale(final Vector3f theVector) {
        x *= theVector.x;
        y *= theVector.y;
        z *= theVector.z;
        return this;
    }

    /**
     *
     * @param theX float
     * @param theY float
     * @param theZ float
     */
    public Vector3f scale(float theX, float theY, float theZ) {
        x *= theX;
        y *= theY;
        z *= theZ;
        return this;
    }

    /**
     * @param theScalar float or int: value the given vector is scaled with
     * @param theVector Vector3f: vector the vector is set to
     */
    public Vector3f scale(final float theScalar, final Vector3f theVector) {
        x = theScalar * theVector.x;
        y = theScalar * theVector.y;
        z = theScalar * theVector.z;
        return this;
    }

    /**
     * Dividing is nearly the the same as scaling, except
     *
     * @param theDivisor
     */
    public Vector3f divide(final float theDivisor) {
        x /= theDivisor;
        y /= theDivisor;
        z /= theDivisor;
        return this;
    }

    public Vector3f divide(final Vector3f theVector) {
        x /= theVector.x;
        y /= theVector.y;
        z /= theVector.z;
        return this;
    }

    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    /**
     * Use this method to calculate the length of a vector, the length of a
     * vector is also known as its magnitude. Vectors have a magnitude and a
     * direction. These values are not explicitly expressed in the vector so
     * they have to be computed.
     *
     * @return float: the length of the vector
     * @shortdesc Calculates the length of the vector.
     */
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public float magnitude() {
        return length();
    }

    /**
     * Sets this vector to the cross product of two given vectors. The cross
     * product returns a vector standing vertical on the two vectors.
     *
     * @param theVectorA
     * @param theVectorB
     */
    public Vector3f cross(final Vector3f theVectorA, final Vector3f theVectorB) {
        return set(theVectorA.cross(theVectorB));
    }

    /**
     * Returns the cross product of two vectors. The cross product returns a
     * vector standing vertical on the two vectors.
     *
     * @param i_vector the other vector
     * @return the cross product
     */
    public Vector3f cross(final Vector3f theVector) {
        return new Vector3f(y * theVector.z - z * theVector.y,
                            z * theVector.x - x * theVector.z,
                            x * theVector.y - y * theVector.x);
    }

    /**
     * Returns the dot product of two vectors. The dot product is the cosinus of
     * the angle between two vectors
     *
     * @param theVector, the other vector
     * @return float, dot product of two vectors
     */
    public float dot(Vector3f theVector) {
        return x * theVector.x + y * theVector.y + z * theVector.z;
    }

    /**
     * Sets the vector to the given one and norms it to the length of 1
     *
     */
    public Vector3f normalize(Vector3f theVector) {
        set(theVector);
        normalize();
        return this;
    }

    /**
     * Norms the vector to the length of 1
     *
     */
    public Vector3f normalize() {
        float inverseMag = 1.0f / (float) Math.sqrt(x * x + y * y + z * z);
        x *= inverseMag;
        y *= inverseMag;
        z *= inverseMag;
        return this;
    }

    /**
     * Interpolates between this vector and the given vector by a given blend
     * value. The blend value has to be between 0 and 1. A blend value 0 would
     * change nothing, a blend value 1 would set this vector to the given one.
     *
     * @param blend float, blend value for interpolation
     * @param i_vector Vector3f, other vector for interpolation
     */
    public void interpolate(final float blend, final Vector3f i_vector) {
        x = x + blend * (i_vector.x - x);
        y = y + blend * (i_vector.y - y);
        z = z + blend * (i_vector.z - z);
    }

    /**
     * Sets a position randomly distributed inside a sphere of unit radius
     * centered at the origin. Orientation will be random and length will range
     * between 0 and 1
     */
    public void randomize() {
        x = generator.nextFloat() * 2.0F - 1.0F;
        y = generator.nextFloat() * 2.0F - 1.0F;
        z = generator.nextFloat() * 2.0F - 1.0F;
        normalize();
    }

    public float angle(Vector3f theVector) {
        float d = dot(theVector) / (length() * theVector.length());
        /**
         * @todo check these lines.
         */
        if (d < -1.0f) {
            d = -1.0f;
        }
        if (d > 1.0f) {
            d = 1.0f;
        }
        return (float) Math.acos(d);
    }

    public float distanceSquared(Vector3f thePoint) {
        float dx = x - thePoint.x;
        float dy = y - thePoint.y;
        float dz = z - thePoint.z;
        return dx * dx + dy * dy + dz * dz;
    }

    public float distance(Vector3f thePoint) {
        float dx = x - thePoint.x;
        float dy = y - thePoint.y;
        float dz = z - thePoint.z;
        return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public float distanceL1(Vector3f thePoint) {
        return Math.abs(x - thePoint.x) + Math.abs(y - thePoint.y)
                + Math.abs(z - thePoint.z);
    }

    public Vector3f min(Vector3f theMin) {
        if (x < theMin.x) {
            x = theMin.x;
        }
        if (y < theMin.y) {
            y = theMin.y;
        }
        if (z < theMin.z) {
            z = theMin.z;
        }
        return this;
    }

    public Vector3f min(float theX, float theY, float theZ) {
        if (x < theX) {
            x = theX;
        }
        if (y < theY) {
            y = theY;
        }
        if (z < theZ) {
            z = theZ;
        }
        return this;
    }

    public Vector3f max(Vector3f theMax) {
        if (x > theMax.x) {
            x = theMax.x;
        }
        if (y > theMax.y) {
            y = theMax.y;
        }
        if (z > theMax.z) {
            z = theMax.z;
        }
        return this;
    }

    public Vector3f max(float theX, float theY, float theZ) {
        if (x > theX) {
            x = theX;
        }
        if (y > theY) {
            y = theY;
        }
        if (z > theZ) {
            z = theZ;
        }
        return this;
    }

    public float[] toArray() {
        final float[] _myArrayRepresentation = new float[3];
        _myArrayRepresentation[0] = x;
        _myArrayRepresentation[1] = y;
        _myArrayRepresentation[2] = z;
        return _myArrayRepresentation;
    }

    public boolean isNaN() {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(final Vector3f theVector) {
        if (x == theVector.x && y == theVector.y && z == theVector.z) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Float.floatToIntBits(this.x);
        hash = 17 * hash + Float.floatToIntBits(this.y);
        hash = 17 * hash + Float.floatToIntBits(this.z);
        return hash;
    }

    public boolean equals(final Object theVector) {
        if (!(theVector instanceof Vector3f)) {
            return false;
        }
        return equals((Vector3f) theVector);
    }

    public boolean almost(final Vector3f theVector) {
        if (Math.abs(x - theVector.x) < ALMOST_THRESHOLD
                && Math.abs(y - theVector.y) < ALMOST_THRESHOLD
                && Math.abs(z - theVector.z) < ALMOST_THRESHOLD) {
            return true;
        } else {
            return false;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn t happen, since we are Cloneable
            throw new InternalError();
        }
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    public static final int X = 0;

    public static final int Y = 1;

    public static final int Z = 2;

    public static final int LENGTH = 3;

    public static int COMPARE_TYPE = LENGTH;

    public int compareTo(Vector3f theVector3f) {
        if (COMPARE_TYPE == LENGTH) {
            final float myLengthSquared = lengthSquared();
            final float myOtherLengthSquared = theVector3f.lengthSquared();
            return myLengthSquared > myOtherLengthSquared ? 1 : (myLengthSquared < myOtherLengthSquared ? -1 : 0);
        } else if (COMPARE_TYPE == X) {
            return x > theVector3f.x ? 1 : (x < theVector3f.x ? -1 : 0);
        } else if (COMPARE_TYPE == Y) {
            return y > theVector3f.y ? 1 : (y < theVector3f.y ? -1 : 0);
        } else if (COMPARE_TYPE == Z) {
            return z > theVector3f.z ? 1 : (z < theVector3f.z ? -1 : 0);
        } else {
            return 0;
        }
    }
}
