package com.img.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "FILE_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String St_photo_name;
    private String St_photo_type;
    private String St_photo_filePath;
    
    private String St_adhar_name;
    private String St_adhar_type;
    private String St_adhar_filePath;
    
    private String St_ssc_name;
    private String St_ssc_type;
    private String St_ssc_filePath;
    
    private String St_hsc_name;
    private String St_hsc_type;
    private String St_hsc_filePath;
    
    
    
}
