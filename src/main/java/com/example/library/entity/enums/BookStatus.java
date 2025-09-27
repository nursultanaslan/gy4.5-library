package com.example.library.entity.enums;

public enum BookStatus {
    /**
     * Book is active and available for loan
     */
    ACTIVE,
    /**
     * Book is inactive and not available for loan
     */
    INACTIVE,
    /**
     * Book is lost or damage and not available for loan
     */
    LOST_DAMAGE;

    /**
     * Returns the default status for new books
     * @return The default BookStatus (ACTIVE)
     */
    public static BookStatus getDefault(){
        return ACTIVE;
    }

    /**
     * Checks if the status is active
     * @return true if status is ACTIVE
     */
    public boolean isActive(){
        return this == ACTIVE;
    }

    /**
     * Checks if the status is inactive
     * @return true if status is INACTIVE
     */
    public boolean isInactive(){
        return this == INACTIVE;
    }

    /**
     * Checks if the status is lost or damage
     * @return true if status is LOST_DAMAGE
     */
    public boolean isLostOrDamage(){
        return this == LOST_DAMAGE;
    }

}