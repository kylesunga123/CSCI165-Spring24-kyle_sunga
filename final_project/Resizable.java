public interface Resizable {
    /**
     * Resizes this object by a percentage.
     *
     * @param percent The percentage by which to resize the object. 
     *                A value of 100 means no change, 200 doubles the size, 
     *                and 50 halves it.
     */
    void resize(int percent);

    
}