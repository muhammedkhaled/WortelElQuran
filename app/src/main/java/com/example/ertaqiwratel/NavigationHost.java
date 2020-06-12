package com.example.ertaqiwratel;

import androidx.fragment.app.Fragment;

interface NavigationHost {
    void navigateTo(Fragment fragment, boolean addToBackstack);
}
