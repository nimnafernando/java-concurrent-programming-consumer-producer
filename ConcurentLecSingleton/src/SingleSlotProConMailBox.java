public interface SingleSlotProConMailBox<E>{
    //any mailbox monitor need to implement this interface and override these methods :
    // monitor objects are passive objects they can not do anything
    public void put(E number); // interface methods do not have body ; if you need to add body , that should be a default method or static method

    public E get();
}
