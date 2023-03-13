package com.udev.marketapi.util;

public interface IMapper <I,O>{
    public O map(I in);
}
