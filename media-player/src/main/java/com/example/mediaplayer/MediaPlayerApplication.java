package com.example.mediaplayer;

import com.example.mediaplayer.controller.controllerArtist.ArtistCreation;
import com.example.mediaplayer.controller.controllerSong.SongCreation;
import com.example.mediaplayer.controller.controllerUser.UserCreation;
import com.example.mediaplayer.model.modelUser.User;
import com.example.mediaplayer.repository.repositoryUser.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class MediaPlayerApplication {


	public static void main(String[] args) {

		SpringApplication.run(MediaPlayerApplication.class, args);
		}
	}

