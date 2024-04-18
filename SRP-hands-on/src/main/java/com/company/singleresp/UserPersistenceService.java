package com.company.singleresp;

public class UserPersistenceService {
    // Taken from Main
    private Store store = new Store();

    public void saveUser(User user) {
        store.store(user);
    }
	
}
