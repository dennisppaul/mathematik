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


public class Vector2f
        implements Serializable, Vectorf {

    private static final long serialVersionUID = -4652533170291767614L;

    public float x;

    public float y;

//    private float[] _myArrayRepresentation = new float[2];
    private static final float ALMOST_THRESHOLD = 0.001f;

    public Vector2f() {
        x = 0.0f;
        y = 0.0f;
    }

    public Vector2f(float theX,
                    float theY) {
        set(theX,
            theY);
    }

    public Vector2f(double theX,
                    double theY) {
        set(theX,
            theY);
    }

    public Vector2f(float[] theVector) {
        set(theVector);
    }

    public Vector2f(double[] theVector) {
        set(theVector);
    }

    public Vector2f(int[] theVector) {
        set(theVector);
    }

    public Vector2f(Vector2f theVector) {
        set(theVector);
    }

    public Vector2f(Vector3f theVector) {
        set(theVector.x, theVector.y);
    }

    public Object clone() {
        return cloneVector();
    }

    public Vector2f cloneVector() {
        return new Vector2f(x, y);
    }

    public final Vector2f set(float theX,
                              float theY) {
        x = theX;
        y = theY;
        return this;
    }

    public final Vector2f set(double theX,
                              double theY) {
        x = (float) theX;
        y = (float) theY;
        return this;
    }

    public final Vector2f set(float[] theVector) {
        x = theVector[0];
        y = theVector[1];
        return this;
    }

    public final Vector2f set(double[] theVector) {
        x = (float) theVector[0];
        y = (float) theVector[1];
        return this;
    }

    public final Vector2f set(int[] theVector) {
        x = theVector[0];
        y = theVector[1];
        return this;
    }

    public final Vector2f set(Vector2f theVector) {
        x = theVector.x;
        y = theVector.y;
        return this;
    }

    public Vector2f add(Vector2f theVectorA,
                        Vector2f theVectorB) {
        x = theVectorA.x + theVectorB.x;
        y = theVectorA.y + theVectorB.y;
        return this;
    }

    public Vector2f add(final int theX, final int theY) {
        x += theX;
        y += theY;
        return this;
    }

    public Vector2f add(final float theX, final float theY) {
        x += theX;
        y += theY;
        return this;
    }

    public Vector2f add(final double theX, final double theY) {
        x += theX;
        y += theY;
        return this;
    }

    public Vector2f add(Vector2f theVector) {
        x += theVector.x;
        y += theVector.y;
        return this;
    }

    public Vector2f sub(Vector2f theVectorA,
                        Vector2f theVectorB) {
        x = theVectorA.x - theVectorB.x;
        y = theVectorA.y - theVectorB.y;
        return this;
    }

    public Vector2f sub(Vector2f theVector) {
        x -= theVector.x;
        y -= theVector.y;
        return this;
    }

    public Vector2f sub(float theX, float theY) {
        x -= theX;
        y -= theY;
        return this;
    }

    public Vector2f scale(float theScalar,
                          Vector2f theVector) {
        x = theScalar * theVector.x;
        y = theScalar * theVector.y;
        return this;
    }

    public Vector2f scale(float theScalar) {
        x *= theScalar;
        y *= theScalar;
        return this;
    }

    public Vector2f scale(Vector2f theVector) {
        x *= theVector.x;
        y *= theVector.y;
        return this;
    }

    public Vector2f scale(float theXScalar, float theYScalar) {
        x *= theXScalar;
        y *= theYScalar;
        return this;
    }

    public float direction() {
        return (float) Math.atan2(y, x);
    }

    public float dot(Vector2f theVector) {
        return x * theVector.x + y * theVector.y;
    }

    public Vector2f cross(Vector2f theVector) {
        x = theVector.y;
        y = -theVector.x;
        return this;
    }

    public Vector2f cross() {
        final float myX = y;
        y = -x;
        x = myX;
        return this;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float lengthSquared() {
        return x * x + y * y;
    }

    public Vector2f normalize(Vector2f theVector) {
        float inverseMag = 1.0f / (float) Math.sqrt(theVector.x * theVector.x + theVector.y * theVector.y);
        x = theVector.x * inverseMag;
        y = theVector.y * inverseMag;
        return this;
    }

    public Vector2f normalize() {
        float inverseMag = 1.0f / (float) Math.sqrt(x * x + y * y);
        x *= inverseMag;
        y *= inverseMag;
        return this;
    }

    public float angle(Vector2f theVector) {
        float d = dot(theVector) / (length() * theVector.length());
        if (d < -1.0f) {
            d = -1.0f;
        }
        if (d > 1.0f) {
            d = 1.0f;
        }
        return (float) Math.acos(d);
    }

    public Vector2f rotate(float theRadians) {
        final float myX = (float) (x * Math.cos(theRadians) - y * Math.sin(theRadians));
        final float myY = (float) (y * Math.cos(theRadians) + x * Math.sin(theRadians));
        x = myX;
        y = myY;
        return this;
    }

    public final float distanceSquared(Vector2f thePoint) {
        float dx = x - thePoint.x;
        float dy = y - thePoint.y;
        return dx * dx + dy * dy;
    }

    public float distance(Vector2f thePoint) {
        float dx = x - thePoint.x;
        float dy = y - thePoint.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public float[] toArray() {
        final float[] _myArrayRepresentation = new float[2];
        _myArrayRepresentation[0] = x;
        _myArrayRepresentation[1] = y;
        return _myArrayRepresentation;
    }

    public boolean isNaN() {
        if (Float.isNaN(x) || Float.isNaN(y)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Vector2f theVector) {
        if (x == theVector.x && y == theVector.y) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Float.floatToIntBits(this.x);
        hash = 73 * hash + Float.floatToIntBits(this.y);
        return hash;
    }

    public boolean equals(final Object theVector) {
        if (!(theVector instanceof Vector2f)) {
            return false;
        }
        return equals((Vector2f) theVector);
    }

    /**
     * Returns true if both x and y are zero
     *
     * @return boolean, true if the vector is zero
     */
    public boolean equalsZero() {
        return x == 0 && y == 0;
    }

    public boolean almost(Vector2f theVector) {
        if (Math.abs(x - theVector.x) < ALMOST_THRESHOLD
                && Math.abs(y - theVector.y) < ALMOST_THRESHOLD) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
