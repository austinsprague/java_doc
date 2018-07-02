/**
 * Generic interface for a List of E objects
 * @param E
 */
public interface List<E> extends Iterable<E> {
    /**
     * size of the list
     * @return Integer size
     */
	public int size();
	/**
	 * get the Element from the list by index
	 * @param index Integer of index of the list
	 * @return Element of list
	 */
    public E get(int index);
    /**
     * Get the index from the list by the Element
     * @param value Element to search in the list
     * @return Integer of index of list
     */
    public int indexOf(E value);
    /**
     * List is empty
     * @return Boolean
     */
    public boolean isEmpty();
    /**
     * if contains the Element in list
     * @param value Element 
     * @return Boolean
     */
    public boolean contains(E value);
    /**
     * Add Element to list
     * @param value Element
     */
    public void add(E value);
    /**
     * add element to an index in the list
     * @param index Integer of index of list
     * @param value Element to add
     */
    public void add(int index, E value);
    /**
     * Add list of elements
     * @param other List of E
     */
    public void addAll(List<E> other);
    /**
     * Remove an Element by index of the list
     * @param index Integer of the index of the list
     */
    public void remove(int index);
    /**
     * Set the Element's value by index
     * @param index Integer of index of list
     * @param value Element to set the existing element
     */
    public void set(int index, E value);
    /**
     * clear list
     */
    public void clear();
}

