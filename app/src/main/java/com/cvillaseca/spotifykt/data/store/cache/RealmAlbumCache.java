package com.cvillaseca.spotifykt.data.store.cache;

import com.cvillaseca.spotifykt.data.entity.AlbumEntity;
import com.cvillaseca.spotifykt.data.entity.Albums;
import com.cvillaseca.spotifykt.data.entity.SearchResponse;
import com.cvillaseca.spotifykt.data.entity.AlbumEntity;
import com.cvillaseca.spotifykt.data.entity.Albums;
import com.cvillaseca.spotifykt.data.entity.SearchResponse;

import java.util.List;

import io.reactivex.Observable;

public class RealmAlbumCache implements  AlbumCache {
    @Override
    public void saveAlbums(List<AlbumEntity> albums) {

    }

    @Override
    public Observable<AlbumEntity> getAlbum(String albumId) {
        return null;
    }

    @Override
    public Observable<Albums> getAlbumsByArtist(String artistId) {
        return null;
    }

    @Override
    public Observable<SearchResponse> searchAlbumsByName(String name) {
        return null;
    }
}
