/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragments;

import futuristicbio.biometrics.DBConnect;
import futuristicbio.biometrics.DataUpdateDashboard;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Futuristic Ltd
 */
public class FragmentEditEnrollment extends javax.swing.JPanel {

    private DataUpdateDashboard data;
    private JSONObject jsonObject;
    private Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();
    private JFileChooser filePicker;
    private Integer p_id;

    /**
     * Creates new form FragmentEditEnrollment
     */
    public FragmentEditEnrollment() {
        initComponents();
        String[] items = {"----Choose State----", "Eastern Equatorial", "Western Equatorial", "Central Equatorial/Bahr el Jabal", "Lake State", "Blue Nile State", "Abyei Administrative Area", "South Kordofan", "Upper Nile", "Western Bahr el-Gahazal", "Jonglei", "Warab", "North Bahr el-Ghazal", "Unity", "General Headquarter"};
        jComboBox4.setModel(new DefaultComboBoxModel<>(items));

        String[] subItems1 = {"----Choose County----", "Budi", "Ikotos", "Kapoeta East", "Kapoeta North", "Kapoeta South", "Lafon", "Magwi", "Torit"};
        subItems.put(items[1], subItems1);

        String[] subItems2 = {"----Choose County----", "Ezo", "Ibba", "Maridi", "Mundri East", "Mundri West", "Mvolo", "Nagero", "Nzara", "Tambura", "Yambio"};
        subItems.put(items[2], subItems2);

        String[] subItems3 = {"----Choose County----", "Juba", "Kajo Keji", "Lainya", "Morobo", "Terekeka", "Yei"};
        subItems.put(items[3], subItems3);

        String[] subItems4 = {"----Choose County----", "Awerial", "Cuelbet", "Rumbek Center", "Rumbek North", "Rumbek East", "Wulu", "Yirol East", "Yirol West"};
        subItems.put(items[4], subItems4);

        String[] subItems5 = {"No County Found"};
        subItems.put(items[5], subItems5);

        String[] subItems6 = {"No County Found"};
        subItems.put(items[6], subItems6);

        String[] subItems7 = {"No County Found"};
        subItems.put(items[7], subItems7);

        String[] subItems8 = {"----Choose County----", "Baliet", "Fashoda", "Longechuk", "Maban", "Maiwut", "Malakai", "Manyo", "Melut", "Nasir", "PanyKang", "Renk", "Ulang"};
        subItems.put(items[8], subItems8);

        String[] subItems9 = {"----Choose County----", "Jur River", "Raja", "Wau"};
        subItems.put(items[9], subItems9);

        String[] subItems10 = {"----Choose County----", "Akobor", "Ayod", "Bor", "Duk", "Fangak", "Nyirol", "Pigi", "Twic East", "uror"};
        subItems.put(items[10], subItems10);

        String[] subItems11 = {"----Choose County----", "Gogrial East", "Gogrial West", "Tonj East", "Tonj North", "Tonj South", "Twic"};
        subItems.put(items[11], subItems11);

        String[] subItems12 = {"----Choose County----", "Aweli Center", "Aweli East", "Aweli North", "Aweli South", "Aweli West"};
        subItems.put(items[12], subItems12);

        String[] subItems13 = {"----Choose County----", "Guit", "Koch", "Leer", "Mayiandit", "Mayom", "Panyijar", "Rubkona"};
        subItems.put(items[13], subItems13);

        String[] subItems14 = {"No County Found"};
        subItems.put(items[14], subItems14);
    }

    public FragmentEditEnrollment(DataUpdateDashboard data, JSONObject jsonObject) throws ParseException {
        initComponents();
        this.data = data;
        this.jsonObject = jsonObject;

        String[] items = {"----Choose State----", "Eastern Equatorial", "Western Equatorial", "Central Equatorial/Bahr el Jabal", "Lake State", "Blue Nile State", "Abyei Administrative Area", "South Kordofan", "Upper Nile", "Western Bahr el-Gahazal", "Jonglei", "Warab", "North Bahr el-Ghazal", "Unity", "General Headquarter"};
        jComboBox4.setModel(new DefaultComboBoxModel<>(items));

        String[] subItems1 = {"----Choose County----", "Budi", "Ikotos", "Kapoeta East", "Kapoeta North", "Kapoeta South", "Lafon", "Magwi", "Torit"};
        subItems.put(items[1], subItems1);

        String[] subItems2 = {"----Choose County----", "Ezo", "Ibba", "Maridi", "Mundri East", "Mundri West", "Mvolo", "Nagero", "Nzara", "Tambura", "Yambio"};
        subItems.put(items[2], subItems2);

        String[] subItems3 = {"----Choose County----", "Juba", "Kajo Keji", "Lainya", "Morobo", "Terekeka", "Yei"};
        subItems.put(items[3], subItems3);

        String[] subItems4 = {"----Choose County----", "Awerial", "Cuelbet", "Rumbek Center", "Rumbek North", "Rumbek East", "Wulu", "Yirol East", "Yirol West"};
        subItems.put(items[4], subItems4);

        String[] subItems5 = {"No County Found"};
        subItems.put(items[5], subItems5);

        String[] subItems6 = {"No County Found"};
        subItems.put(items[6], subItems6);

        String[] subItems7 = {"No County Found"};
        subItems.put(items[7], subItems7);

        String[] subItems8 = {"----Choose County----", "Baliet", "Fashoda", "Longechuk", "Maban", "Maiwut", "Malakai", "Manyo", "Melut", "Nasir", "PanyKang", "Renk", "Ulang"};
        subItems.put(items[8], subItems8);

        String[] subItems9 = {"----Choose County----", "Jur River", "Raja", "Wau"};
        subItems.put(items[9], subItems9);

        String[] subItems10 = {"----Choose County----", "Akobor", "Ayod", "Bor", "Duk", "Fangak", "Nyirol", "Pigi", "Twic East", "uror"};
        subItems.put(items[10], subItems10);

        String[] subItems11 = {"----Choose County----", "Gogrial East", "Gogrial West", "Tonj East", "Tonj North", "Tonj South", "Twic"};
        subItems.put(items[11], subItems11);

        String[] subItems12 = {"----Choose County----", "Aweli Center", "Aweli East", "Aweli North", "Aweli South", "Aweli West"};
        subItems.put(items[12], subItems12);

        String[] subItems13 = {"----Choose County----", "Guit", "Koch", "Leer", "Mayiandit", "Mayom", "Panyijar", "Rubkona"};
        subItems.put(items[13], subItems13);

        String[] subItems14 = {"No County Found"};
        subItems.put(items[14], subItems14);

        JSONArray arr = jsonObject.getJSONArray("police_details");

        JSONObject firstObject = null;

        String firstname = null;
        String middlename = null;
        String othername = null;
        String surname = null;
        String gender = null;
        String position_held = null;
        String email = null;
        String police_idno = null;
        String place_of_birth = null;
        String state_of_origin = null;
        String height = null;
        String weight = null;
        String blood_group = null;
        String date_birth = null;
        String date2_birth = null;
        String date3_birth;
        String state = null;
        String county = null;
        String rank = null;
        String permanent_address = null;
        String present_address = null;
        String duty_station = null;
        String retired = null;
        String national_id = null;
        String marital_status = null;
        String id_number;
        String letter_employment = null;
        String father_name = null;
        String father_address = null;
        String mother_name = null;
        String mother_address = null;
        String dependent = null;
        String dependency_details = null;
        String nextkin_name = null;
        String nextkin_address = null;
        String nextkin_job = null;
        String nextkin_phone = null;
        String spouse_name = null;
        String spouse_address = null;
        String spouse_job = null;
        String spouse2_name = null;
        String spouse2_address = null;
        String spouse2_job = null;
        String child_name = null;
        Date child_date_birth = null;
        String child2_name = null;
        Date child2_date_birth = null;
        String child3_name = null;
        Date child3_date_birth = null;
        String imprisoned = null;
        String imprisonment_details = null;
        String health_condition = null;
        String health_details = null;
        String battles = null;
        String battle_details = null;
        String date;
        String date1;
        String date2;
        String date3;
        String date4;
        String date5;
        String date6;
        String date7;
        String date8;
        String date9;
        String date10;
        String date11;
        String date12;
        String date13;
        String date14;
        String date15;
        String date16;
        String date17;
        String date18;
        String date19;
        String date20;
        String date21;
        String date22;
        String date23;
        String date24;
        String date25;
        String date26;
        String date27;
        String date28;
        String date29;
        String date30;
        String date31;
        String date32;
        String date33;
        Date participation_date = null;
        String place_of_participation = null;
        String additional_info = null;
        String arabic;
        String english;
        String other_language;
        String language2;
        String medical_fitness;
        String injury;
        String physical_challenge;
        String primary_institution = null;
        String primary_location = null;
        String primary_from = null;
        String primary_to = null;
        String primary_certificate = null;
        String secondary_institution = null;
        String secondary_location = null;
        Date secondary_from = null;
        Date secondary_to = null;
        String secondary_certificate = null;
        String college_institution = null;
        String college_location = null;
        Date college_from = null;
        Date college_to = null;
        String college_certificate = null;
        String university_institution = null;
        String university_location = null;
        Date university_from = null;
        Date university_to = null;
        String university_certificate = null;
        String post_graduate = null;
        String post_graduate_location = null;
        Date post_graduate_from = null;
        Date post_graduate_to = null;
        String post_graduate_certificate = null;
        String other = null;
        String other_location = null;
        Date other_from = null;
        Date other_to = null;
        String other_certificate = null;
        String police_work = null;
        String police_work_location = null;
        String police_work_rank = null;
        Date police_work_from = null;
        Date police_work_to = null;
        String police_work2 = null;
        String police_work_location2 = null;
        String police_work_rank2 = null;
        Date police_work_from2 = null;
        Date police_work_to2 = null;
        String military_work = null;
        String military_description = null;
        String military_work_location = null;
        String military_provided_by = null;
        Date military_duration_from = null;
        Date military_duration_to = null;
        String military_work2 = null;
        String military_description2 = null;
        String military_work_location2 = null;
        String military_provided_by2 = null;
        Date military_duration_from2 = null;
        Date military_duration_to2 = null;
        String civil_work = null;
        String civil_description = null;
        String civil_work_location = null;
        String civil_provided_by = null;
        Date civil_duration_from = null;
        Date civil_duration_to = null;
        String civil_work2 = null;
        String civil_description2 = null;
        String civil_work_location2 = null;
        String civil_provided_by2 = null;
        Date civil_duration_from2 = null;
        Date civil_duration_to2 = null;
        String police_training = null;
        String police_training_module = null;
        String police_training_provided_by = null;
        String police_training_location = null;
        String police_training_qualified = null;
        Date police_training_period_from = null;
        Date police_training_period_to = null;
        String police_training2 = null;
        String police_training_module2 = null;
        String police_training_provided_by2 = null;
        String police_training_location2 = null;
        String police_training_qualified2 = null;
        Date police_training_period_from2 = null;
        Date police_training_period_to2 = null;
        String military_training = null;
        String military_training_module = null;
        String military_training_provided_by = null;
        String military_training_location = null;
        String military_training_qualified = null;
        Date military_training_period_from = null;
        Date military_training_period_to = null;
        String military_training2 = null;
        String military_training_module2 = null;
        String military_training_provided_by2 = null;
        String military_training_location2 = null;
        String military_training_qualified2 = null;
        Date military_training_period_from2 = null;
        Date military_training_period_to2 = null;
        String calibre = null;
        String weapon_type = null;
        String serial_number = null;
        String ammunition_number = null;
        String provided_by = null;
        String location = null;
        Date receipt_date = null;
        String calibre1 = null;
        String weapon1_type = null;
        String serial_number1 = null;
        String ammunition1 = null;
        String provided_by1 = null;
        String location1 = null;
        Date receipt_date1 = null;
        String calibre2 = null;
        String weapon2_type = null;
        String serial_number2 = null;
        String ammunition2 = null;
        String provided_by2 = null;
        String location2 = null;
        Date receipt_date2 = null;
        String qualification1 = null;
        String qualification2 = null;
        String qualification3 = null;
        p_id = null;

        for (int i = 0; i < arr.length(); i++) {
            firstObject = arr.getJSONObject(i);

            firstname = firstObject.getString("first_name");
            middlename = firstObject.getString("middle_name");
            othername = firstObject.getString("other_name");
            surname = firstObject.getString("surname");
            gender = firstObject.getString("gender");
            position_held = firstObject.getString("position_held");
            email = firstObject.getString("email");
            police_idno = firstObject.getString("police_idno");
            place_of_birth = firstObject.getString("place_of_birth");
            state_of_origin = firstObject.getString("state_of_origin");
            height = firstObject.getString("height");
            weight = firstObject.getString("weight");
            blood_group = firstObject.getString("blood_group");
            date_birth = firstObject.getString("date_birth");
            state = firstObject.getString("state");
            county = firstObject.getString("county");
            rank = firstObject.getString("rank");
            permanent_address = firstObject.getString("permanent_address");
            present_address = firstObject.getString("present_address");
            duty_station = firstObject.getString("duty_station");
            retired = firstObject.getString("retired");
            national_id = firstObject.getString("national_id");
            marital_status = firstObject.getString("marital_status");
            id_number = firstObject.getString("id_number");
            letter_employment = firstObject.getString("letter_employment");
            father_name = firstObject.getString("father_name");
            father_address = firstObject.getString("father_address");
            mother_name = firstObject.getString("mother_name");
            mother_address = firstObject.getString("mother_address");
            dependent = firstObject.getString("dependent");
            dependency_details = firstObject.getString("dependency_details");
            nextkin_name = firstObject.getString("nextkin_name");
            nextkin_address = firstObject.getString("nextkin_address");
            nextkin_job = firstObject.getString("nextkin_job");
            nextkin_phone = firstObject.getString("nextkin_phone");
            spouse_name = firstObject.getString("spouse_name");
            spouse_address = firstObject.getString("spouse_address");
            spouse_job = firstObject.getString("spouse_job");
            spouse2_name = firstObject.getString("spouse2_name");
            spouse2_address = firstObject.getString("spouse2_address");
            spouse2_job = firstObject.getString("spouse2_job");
            child_name = firstObject.getString("child_name");
            date_birth = firstObject.getString("child_date_birth");
            child_date_birth = new SimpleDateFormat("yyyy-MM-dd").parse(date_birth);
            child2_name = firstObject.getString("child2_name");
            date2_birth = firstObject.getString("child2_date_birth");
            child2_date_birth = new SimpleDateFormat("yyyy-MM-dd").parse(date2_birth);
            child3_name = firstObject.getString("child3_name");
            date3_birth = firstObject.getString("child3_date_birth");
            child3_date_birth = new SimpleDateFormat("yyyy-MM-dd").parse(date3_birth);
            imprisoned = firstObject.getString("imprisoned");
            imprisonment_details = firstObject.getString("imprisonment_details");
            health_condition = firstObject.getString("health_condition");
            health_details = firstObject.getString("health_details");
            battles = firstObject.getString("battles");
            battle_details = firstObject.getString("battle_details");
            date = firstObject.getString("participation_date");
            participation_date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            place_of_participation = firstObject.getString("place_of_participation");
            additional_info = firstObject.getString("additional_info");
            arabic = firstObject.getString("arabic");
            english = firstObject.getString("english");
            other_language = firstObject.getString("other_language");
            language2 = firstObject.getString("language2");
            medical_fitness = firstObject.getString("medical_fitness");
            injury = firstObject.getString("injury");
            physical_challenge = firstObject.getString("physical_challenge");
            primary_institution = firstObject.getString("primary_institution");
            primary_location = firstObject.getString("primary_location");
            primary_from = firstObject.getString("primary_from");
            primary_to = firstObject.getString("primary_to");
            primary_certificate = firstObject.getString("primary_certificate");
            secondary_institution = firstObject.getString("secondary_institution");
            secondary_location = firstObject.getString("secondary_location");
            date1 = firstObject.getString("secondary_from");
            date2 = firstObject.getString("secondary_to");
            secondary_from = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
            secondary_to = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
            secondary_certificate = firstObject.getString("secondary_certificate");
            college_institution = firstObject.getString("college_institution");
            college_location = firstObject.getString("college_location");
            date3 = firstObject.getString("college_from");
            date4 = firstObject.getString("college_to");
            college_from = new SimpleDateFormat("yyyy-MM-dd").parse(date3);
            college_to = new SimpleDateFormat("yyyy-MM-dd").parse(date4);
            college_certificate = firstObject.getString("college_certificate");
            university_institution = firstObject.getString("university_institution");
            university_location = firstObject.getString("university_location");
            date5 = firstObject.getString("university_from");
            date6 = firstObject.getString("university_to");
            university_from = new SimpleDateFormat("yyyy-MM-dd").parse(date5);
            university_to = new SimpleDateFormat("yyyy-MM-dd").parse(date6);
            university_certificate = firstObject.getString("university_certificate");
            post_graduate = firstObject.getString("post_graduate");
            post_graduate_location = firstObject.getString("post_graduate_location");
            date7 = firstObject.getString("post_graduate_from");
            date8 = firstObject.getString("post_graduate_to");
            post_graduate_from = new SimpleDateFormat("yyyy-MM-dd").parse(date7);
            post_graduate_to = new SimpleDateFormat("yyyy-MM-dd").parse(date8);
            post_graduate_certificate = firstObject.getString("post_graduate_certificate");
            other = firstObject.getString("other");
            other_location = firstObject.getString("other_location");
            date9 = firstObject.getString("other_from");
            date10 = firstObject.getString("other_to");
            other_from = new SimpleDateFormat("yyyy-MM-dd").parse(date9);
            other_to = new SimpleDateFormat("yyyy-MM-dd").parse(date10);
            other_certificate = firstObject.getString("other_certificate");
            police_work = firstObject.getString("police_work");
            police_work_location = firstObject.getString("police_work_location");
            police_work_rank = firstObject.getString("police_work_rank");
            date11 = firstObject.getString("police_work_from");
            date12 = firstObject.getString("police_work_to");
            police_work_from = new SimpleDateFormat("yyyy-MM-dd").parse(date11);
            police_work_to = new SimpleDateFormat("yyyy-MM-dd").parse(date12);
            police_work2 = firstObject.getString("police_work2");
            police_work_location2 = firstObject.getString("police_work_location2");
            police_work_rank2 = firstObject.getString("police_work_rank2");
            date13 = firstObject.getString("police_work_from2");
            date14 = firstObject.getString("police_work_to2");
            police_work_from2 = new SimpleDateFormat("yyyy-MM-dd").parse(date13);
            police_work_to2 = new SimpleDateFormat("yyyy-MM-dd").parse(date14);
            military_work = firstObject.getString("military_work");
            military_description = firstObject.getString("military_description");
            military_work_location = firstObject.getString("military_work_location");
            military_provided_by = firstObject.getString("military_provided_by");
            date15 = firstObject.getString("military_duration_from");
            date16 = firstObject.getString("military_duration_to");
            military_duration_from = new SimpleDateFormat("yyyy-MM-dd").parse(date15);
            military_duration_to = new SimpleDateFormat("yyyy-MM-dd").parse(date16);
            military_work2 = firstObject.getString("military_work2");
            military_description2 = firstObject.getString("military_description2");
            military_work_location2 = firstObject.getString("military_work_location2");
            military_provided_by2 = firstObject.getString("military_provided_by2");
            date17 = firstObject.getString("military_duration_from2");
            date18 = firstObject.getString("military_duration_to2");
            military_duration_from2 = new SimpleDateFormat("yyyy-MM-dd").parse(date17);
            military_duration_to2 = new SimpleDateFormat("yyyy-MM-dd").parse(date18);
            civil_work = firstObject.getString("civil_work");
            civil_description = firstObject.getString("civil_description");
            civil_work_location = firstObject.getString("civil_work_location");
            civil_provided_by = firstObject.getString("civil_provided_by");
            date19 = firstObject.getString("civil_duration_from");
            date20 = firstObject.getString("civil_duration_to");
            civil_duration_from = new SimpleDateFormat("yyyy-MM-dd").parse(date19);
            civil_duration_to = new SimpleDateFormat("yyyy-MM-dd").parse(date20);
            civil_work2 = firstObject.getString("civil_work2");
            civil_description2 = firstObject.getString("civil_description2");
            civil_work_location2 = firstObject.getString("civil_work_location2");
            civil_provided_by2 = firstObject.getString("civil_provided_by2");
            date21 = firstObject.getString("civil_duration_from2");
            date22 = firstObject.getString("civil_duration_to2");
            civil_duration_from2 = new SimpleDateFormat("yyyy-MM-dd").parse(date21);
            civil_duration_to2 = new SimpleDateFormat("yyyy-MM-dd").parse(date22);
            police_training = firstObject.getString("police_training");
            police_training_module = firstObject.getString("police_training_module");
            police_training_provided_by = firstObject.getString("police_training_provided_by");
            police_training_location = firstObject.getString("police_training_location");
            police_training_qualified = firstObject.getString("police_training_qualified");
            date23 = firstObject.getString("police_training_period_from");
            date24 = firstObject.getString("police_training_period_to");
            police_training_period_from = new SimpleDateFormat("yyyy-MM-dd").parse(date23);
            police_training_period_to = new SimpleDateFormat("yyyy-MM-dd").parse(date24);
            police_training2 = firstObject.getString("police_training2");
            police_training_module2 = firstObject.getString("police_training_module2");
            police_training_provided_by2 = firstObject.getString("police_training_provided_by2");
            police_training_location2 = firstObject.getString("police_training_location2");
            police_training_qualified2 = firstObject.getString("police_training_qualified2");
            date25 = firstObject.getString("police_training_period_from2");
            date26 = firstObject.getString("police_training_period_to2");
            police_training_period_from2 = new SimpleDateFormat("yyyy-MM-dd").parse(date25);
            police_training_period_to2 = new SimpleDateFormat("yyyy-MM-dd").parse(date26);
            military_training = firstObject.getString("military_training");
            military_training_module = firstObject.getString("military_training_module");
            military_training_provided_by = firstObject.getString("military_training_provided_by");
            military_training_location = firstObject.getString("military_training_location");
            military_training_qualified = firstObject.getString("military_training_qualified");
            date27 = firstObject.getString("military_training_period_from");
            date28 = firstObject.getString("military_training_period_to");
            military_training_period_from = new SimpleDateFormat("yyyy-MM-dd").parse(date27);
            military_training_period_to = new SimpleDateFormat("yyyy-MM-dd").parse(date28);
            military_training2 = firstObject.getString("military_training2");
            military_training_module2 = firstObject.getString("military_training_module2");
            military_training_provided_by2 = firstObject.getString("military_training_provided_by2");
            military_training_location2 = firstObject.getString("military_training_location2");
            military_training_qualified2 = firstObject.getString("military_training_qualified2");
            date29 = firstObject.getString("military_training_period_from2");
            date30 = firstObject.getString("military_training_period_to2");
            military_training_period_from2 = new SimpleDateFormat("yyyy-MM-dd").parse(date29);
            military_training_period_to2 = new SimpleDateFormat("yyyy-MM-dd").parse(date30);
            calibre = firstObject.getString("calibre");
            weapon_type = firstObject.getString("weapon_type");
            serial_number = firstObject.getString("serial_number");
            ammunition_number = firstObject.getString("ammunition_number");
            provided_by = firstObject.getString("provided_by");
            location = firstObject.getString("location");
            date31 = firstObject.getString("receipt_date");
            receipt_date = new SimpleDateFormat("yyyy-MM-dd").parse(date30);
            calibre1 = firstObject.getString("calibre1");
            weapon1_type = firstObject.getString("weapon1_type");
            serial_number1 = firstObject.getString("serial_number1");
            ammunition1 = firstObject.getString("ammunition1");
            provided_by1 = firstObject.getString("provided_by1");
            location1 = firstObject.getString("location1");
            date32 = firstObject.getString("receipt_date1");
            receipt_date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date32);
            calibre2 = firstObject.getString("calibre2");
            weapon2_type = firstObject.getString("weapon2_type");
            serial_number2 = firstObject.getString("serial_number2");
            ammunition2 = firstObject.getString("ammunition2");
            provided_by2 = firstObject.getString("provided_by2");
            location2 = firstObject.getString("location2");
            date33 = firstObject.getString("receipt_date2");
            receipt_date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date33);
            qualification1 = firstObject.getString("qualification1");
            qualification2 = firstObject.getString("qualification2");
            qualification3 = firstObject.getString("qualification3");
            p_id = firstObject.getInt("id");
        }

        jTextField1.setText(police_idno);
        jComboBox4.setSelectedItem(state);
        jComboBox1.setSelectedItem(county);
        if (retired.equals("retired")) {
            jRadioButton9.setSelected(true);
        } else {
            jRadioButton10.setSelected(true);
        }
        jComboBox5.setSelectedItem(rank);
        jTextField12.setText(duty_station);
        jLabel216.setText(letter_employment);
        jTextField6.setText(firstname);
        jTextField4.setText(middlename);
        jTextField5.setText(surname);
        jTextField9.setText(othername);
        jComboBox2.setSelectedItem(gender);
        jTextField7.setText(position_held);
        jTextField8.setText(email);
        jTextField10.setText(place_of_birth);
        jTextField2.setText(date_birth);
        jTextField11.setText(state_of_origin);
        jTextField13.setText(height);
        jTextField14.setText(weight);
        jTextField3.setText(blood_group);
        jTextField16.setText(permanent_address);
        jTextField17.setText(present_address);
        jTextField18.setText(national_id);
        jComboBox3.setSelectedItem(marital_status);
        jTextField19.setText(father_name);
        jTextField20.setText(father_address);
        jTextField21.setText(mother_name);
        jTextField22.setText(mother_address);
        if (dependent.equals("Yes")) {
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton2.setSelected(true);
        }
        jTextArea1.setText(dependency_details);
        jTextField23.setText(nextkin_name);
        jTextField24.setText(nextkin_address);
        jTextField25.setText(nextkin_job);
        jTextField26.setText(nextkin_phone);
        jTextField27.setText(spouse_name);
        jTextField28.setText(spouse_address);
        jTextField37.setText(spouse_job);
        jTextField38.setText(spouse2_name);
        jTextField29.setText(spouse2_address);
        jTextField30.setText(spouse2_job);
        jTextField31.setText(child_name);
        jDateSearchFrom2.setDate(child_date_birth);
        jTextField33.setText(child2_name);
        jDateSearchFrom1.setDate(child2_date_birth);
        jTextField35.setText(child3_name);
        jDateSearchFrom3.setDate(child3_date_birth);
        if (imprisoned.equals("Yes")) {
            jRadioButton3.setSelected(true);
        } else {
            jRadioButton4.setSelected(true);
        }
        jTextArea2.setText(imprisonment_details);
        if (health_condition.equals("Good")) {
            jRadioButton7.setSelected(true);
        } else {
            jRadioButton8.setSelected(true);
        }
        jTextArea4.setText(health_details);
        if (battles.equals("Yes")) {
            jRadioButton5.setSelected(true);
        } else {
            jRadioButton6.setSelected(true);
        }
        jTextArea3.setText(battle_details);
        jDateSearchFrom4.setDate(participation_date);
        jTextField32.setText(place_of_participation);
        jTextArea5.setText(additional_info);
        jTextField34.setText(primary_institution);
        jTextField36.setText(secondary_institution);
        jTextField39.setText(college_institution);
        jTextField40.setText(university_institution);
        jTextField41.setText(post_graduate);
        jTextField42.setText(other);
        jTextField43.setText(primary_location);
        jTextField44.setText(secondary_location);
        jTextField45.setText(college_location);
        jTextField46.setText(university_location);
        jTextField47.setText(post_graduate_location);
        jTextField49.setText(other_location);
        jTextField15.setText(primary_from);
        jTextField122.setText(primary_to);
        jTextField48.setText(primary_certificate);
        jTextField50.setText(secondary_certificate);
        jTextField51.setText(college_certificate);
        jTextField52.setText(university_certificate);
        jTextField53.setText(post_graduate_certificate);
        jTextField54.setText(other_certificate);
        jDateSearchFrom8.setDate(secondary_from);
        jDateSearchFrom7.setDate(secondary_to);
        jDateSearchFrom9.setDate(college_from);
        jDateSearchFrom10.setDate(college_to);
        jDateSearchFrom13.setDate(university_from);
        jDateSearchFrom11.setDate(university_to);
        jDateSearchFrom12.setDate(post_graduate_from);
        jDateSearchFrom14.setDate(post_graduate_to);
        jDateSearchFrom16.setDate(other_from);
        jDateSearchFrom15.setDate(other_to);
        jTextField55.setText(police_work);
        jTextField56.setText(police_work_location);
        jTextField57.setText(police_work_rank);
        jDateSearchFrom18.setDate(police_work_from);
        jDateSearchFrom17.setDate(police_work_to);
        jTextField58.setText(police_work2);
        jTextField59.setText(police_work_location2);
        jDateSearchFrom20.setDate(police_work_from2);
        jDateSearchFrom19.setDate(police_work_to2);
        jTextField60.setText(police_work_rank2);
        jTextField61.setText(civil_work);
        jTextField62.setText(civil_description);
        jTextField63.setText(civil_provided_by);
        jTextField64.setText(civil_work_location);
        jDateSearchFrom21.setDate(civil_duration_from);
        jDateSearchFrom22.setDate(civil_duration_to);
        jTextField65.setText(civil_work2);
        jTextField66.setText(civil_description2);
        jTextField67.setText(civil_provided_by2);
        jTextField68.setText(civil_work_location2);
        jDateSearchFrom23.setDate(civil_duration_from2);
        jDateSearchFrom24.setDate(civil_duration_to2);
        jTextField69.setText(military_work);
        jTextField70.setText(military_description);
        jTextField71.setText(military_provided_by);
        jTextField72.setText(military_work_location);
        jDateSearchFrom25.setDate(military_duration_from);
        jDateSearchFrom26.setDate(military_duration_to);
        jTextField73.setText(military_work2);
        jTextField74.setText(military_description2);
        jTextField75.setText(military_provided_by2);
        jTextField76.setText(military_work_location2);
        jDateSearchFrom27.setDate(military_duration_from2);
        jDateSearchFrom28.setDate(military_duration_to2);
        jTextField77.setText(police_training);
        jTextField78.setText(police_training_module);
        jTextField79.setText(police_training_provided_by);
        jTextField80.setText(police_training_location);
        jTextField85.setText(police_training_qualified);
        jDateSearchFrom29.setDate(police_training_period_from);
        jDateSearchFrom30.setDate(police_training_period_to);
        jTextField81.setText(police_training2);
        jTextField82.setText(police_training_module2);
        jTextField83.setText(police_training_provided_by2);
        jTextField84.setText(police_training_location2);
        jTextField86.setText(police_training_qualified2);
        jDateSearchFrom31.setDate(police_training_period_from2);
        jDateSearchFrom32.setDate(police_training_period_to2);
        jTextField87.setText(military_training);
        jTextField88.setText(military_training_module);
        jTextField89.setText(military_training_provided_by);
        jTextField90.setText(military_training_location);
        jTextField95.setText(military_training_qualified);
        jDateSearchFrom33.setDate(military_training_period_from);
        jDateSearchFrom34.setDate(military_training_period_to);
        jTextField91.setText(military_training2);
        jTextField92.setText(military_training_module2);
        jTextField93.setText(military_training_provided_by2);
        jTextField94.setText(military_training_location2);
        jTextField96.setText(military_training_qualified2);
        jDateSearchFrom35.setDate(military_training_period_from2);
        jDateSearchFrom36.setDate(military_training_period_to2);
        jTextField97.setText(qualification1);
        jTextField98.setText(qualification2);
        jTextField99.setText(qualification3);
        jTextField102.setText(calibre);
        jTextField103.setText(weapon_type);
        jTextField106.setText(serial_number);
        jTextField107.setText(ammunition_number);
        jTextField108.setText(provided_by);
        jTextField109.setText(location);
        jDateSearchFrom37.setDate(receipt_date);
        jTextField110.setText(calibre1);
        jTextField111.setText(weapon1_type);
        jTextField112.setText(serial_number1);
        jTextField113.setText(ammunition1);
        jTextField114.setText(provided_by1);
        jTextField115.setText(location1);
        jDateSearchFrom38.setDate(receipt_date1);
        jTextField116.setText(calibre2);
        jTextField117.setText(weapon2_type);
        jTextField118.setText(serial_number2);
        jTextField119.setText(ammunition2);
        jTextField120.setText(provided_by2);
        jTextField121.setText(location2);
        jDateSearchFrom39.setDate(receipt_date2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel216 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        roundCorner2 = new SwingClass.RoundCorner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        roundCorner4 = new SwingClass.RoundCorner();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jDateSearchFrom1 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom2 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom3 = new com.toedter.calendar.JDateChooser();
        jPanel26 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel16 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jPanel28 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel63 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel64 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel29 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jDateSearchFrom4 = new com.toedter.calendar.JDateChooser();
        jPanel17 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jTextField49 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jTextField48 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jDateSearchFrom7 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom8 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom9 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom10 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom11 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom12 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom13 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom14 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom15 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom16 = new com.toedter.calendar.JDateChooser();
        jLabel156 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField122 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jTextField56 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jTextField57 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jDateSearchFrom17 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom18 = new com.toedter.calendar.JDateChooser();
        jLabel119 = new javax.swing.JLabel();
        jTextField58 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jTextField59 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jTextField60 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jDateSearchFrom19 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom20 = new com.toedter.calendar.JDateChooser();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jTextField61 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jTextField62 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jTextField63 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jDateSearchFrom21 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom22 = new com.toedter.calendar.JDateChooser();
        jLabel133 = new javax.swing.JLabel();
        jTextField64 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jTextField65 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jTextField66 = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jTextField67 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        jTextField68 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jDateSearchFrom23 = new com.toedter.calendar.JDateChooser();
        jLabel140 = new javax.swing.JLabel();
        jDateSearchFrom24 = new com.toedter.calendar.JDateChooser();
        jPanel36 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jTextField69 = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jTextField70 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jTextField71 = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        jTextField72 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jDateSearchFrom25 = new com.toedter.calendar.JDateChooser();
        jLabel148 = new javax.swing.JLabel();
        jDateSearchFrom26 = new com.toedter.calendar.JDateChooser();
        jLabel149 = new javax.swing.JLabel();
        jTextField73 = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        jTextField74 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jTextField75 = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        jTextField76 = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jDateSearchFrom27 = new com.toedter.calendar.JDateChooser();
        jLabel155 = new javax.swing.JLabel();
        jDateSearchFrom28 = new com.toedter.calendar.JDateChooser();
        jPanel19 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jTextField77 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jTextField78 = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        jTextField79 = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jDateSearchFrom29 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom30 = new com.toedter.calendar.JDateChooser();
        jLabel163 = new javax.swing.JLabel();
        jTextField80 = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jTextField81 = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jTextField82 = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jTextField83 = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jTextField84 = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jDateSearchFrom31 = new com.toedter.calendar.JDateChooser();
        jLabel171 = new javax.swing.JLabel();
        jDateSearchFrom32 = new com.toedter.calendar.JDateChooser();
        jTextField85 = new javax.swing.JTextField();
        jTextField86 = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jTextField87 = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        jTextField88 = new javax.swing.JTextField();
        jLabel175 = new javax.swing.JLabel();
        jTextField89 = new javax.swing.JTextField();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jDateSearchFrom33 = new com.toedter.calendar.JDateChooser();
        jDateSearchFrom34 = new com.toedter.calendar.JDateChooser();
        jLabel178 = new javax.swing.JLabel();
        jTextField90 = new javax.swing.JTextField();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jTextField91 = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        jTextField92 = new javax.swing.JTextField();
        jLabel182 = new javax.swing.JLabel();
        jTextField93 = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        jTextField94 = new javax.swing.JTextField();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jDateSearchFrom35 = new com.toedter.calendar.JDateChooser();
        jLabel186 = new javax.swing.JLabel();
        jDateSearchFrom36 = new com.toedter.calendar.JDateChooser();
        jTextField95 = new javax.swing.JTextField();
        jTextField96 = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jTextField97 = new javax.swing.JTextField();
        jTextField98 = new javax.swing.JTextField();
        jTextField99 = new javax.swing.JTextField();
        jTextField100 = new javax.swing.JTextField();
        jTextField101 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jTextField104 = new javax.swing.JTextField();
        jTextField105 = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel43 = new javax.swing.JPanel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jPanel42 = new javax.swing.JPanel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jPanel21 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jTextField102 = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        jTextField103 = new javax.swing.JTextField();
        jLabel190 = new javax.swing.JLabel();
        jTextField106 = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        jTextField107 = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        jTextField108 = new javax.swing.JTextField();
        jLabel198 = new javax.swing.JLabel();
        jTextField109 = new javax.swing.JTextField();
        jLabel199 = new javax.swing.JLabel();
        jDateSearchFrom37 = new com.toedter.calendar.JDateChooser();
        jPanel45 = new javax.swing.JPanel();
        jLabel200 = new javax.swing.JLabel();
        jTextField110 = new javax.swing.JTextField();
        jLabel201 = new javax.swing.JLabel();
        jTextField111 = new javax.swing.JTextField();
        jLabel202 = new javax.swing.JLabel();
        jTextField112 = new javax.swing.JTextField();
        jLabel203 = new javax.swing.JLabel();
        jTextField113 = new javax.swing.JTextField();
        jLabel204 = new javax.swing.JLabel();
        jTextField114 = new javax.swing.JTextField();
        jLabel205 = new javax.swing.JLabel();
        jTextField115 = new javax.swing.JTextField();
        jLabel206 = new javax.swing.JLabel();
        jDateSearchFrom38 = new com.toedter.calendar.JDateChooser();
        jLabel214 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jTextField116 = new javax.swing.JTextField();
        jLabel208 = new javax.swing.JLabel();
        jTextField117 = new javax.swing.JTextField();
        jLabel209 = new javax.swing.JLabel();
        jTextField118 = new javax.swing.JTextField();
        jLabel210 = new javax.swing.JLabel();
        jTextField119 = new javax.swing.JTextField();
        jLabel211 = new javax.swing.JLabel();
        jTextField120 = new javax.swing.JTextField();
        jLabel212 = new javax.swing.JLabel();
        jTextField121 = new javax.swing.JTextField();
        jLabel213 = new javax.swing.JLabel();
        jDateSearchFrom39 = new com.toedter.calendar.JDateChooser();
        jLabel215 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jCheckBox19 = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jLabel219 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jTextField126 = new javax.swing.JTextField();
        jLabel224 = new javax.swing.JLabel();
        jTextField127 = new javax.swing.JTextField();
        jLabel225 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();

        jTabbedPane1.setBackground(new java.awt.Color(0, 112, 54));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1404, 850));

        jPanel8.setBackground(java.awt.Color.white);

        jPanel13.setBackground(java.awt.Color.white);
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Police ID Number");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("State");

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Choose State----" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("County");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Choose County----" }));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Rank");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Duty Station");

        jTextField12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Letter of Employment(Required)");

        jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Choose Rank----", "General", "Lt. General", "Major General", "Brigadier General", "Colonel", "Lt. Colonel", "Major", "Captain", "Lieutenant", "2nd Lieutenant", "Warrant Officer", "Sergeant Major", "Sergeant", "Corporal", "Lance Corporal", "Constable" }));

        jLabel216.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(0, 112, 54));

        jRadioButton9.setBackground(java.awt.Color.white);
        jRadioButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton9.setText("Retired");

        jRadioButton10.setBackground(java.awt.Color.white);
        jRadioButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton10.setText("Not Retired");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, 381, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jRadioButton9)
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButton10)))
                .addGap(86, 86, 86)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel216)
                        .addGap(73, 500, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(11, 11, 11)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel216)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Official Details", jPanel8);

        jPanel14.setBackground(java.awt.Color.white);

        roundCorner2.setBackground(java.awt.Color.white);
        roundCorner2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        roundCorner2.setPreferredSize(new java.awt.Dimension(411, 497));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Middle Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Surname");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Other Name");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Gender");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Position Held:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Email Address");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Choose Gender----", "Female", "Male", "Other" }));

        javax.swing.GroupLayout roundCorner2Layout = new javax.swing.GroupLayout(roundCorner2);
        roundCorner2.setLayout(roundCorner2Layout);
        roundCorner2Layout.setHorizontalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField6)
                    .addComponent(jTextField5)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField9)
                    .addComponent(jComboBox2, 0, 404, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8)
                    .addGroup(roundCorner2Layout.createSequentialGroup()
                        .addGroup(roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundCorner2Layout.setVerticalGroup(
            roundCorner2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundCorner4.setBackground(java.awt.Color.white);
        roundCorner4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        roundCorner4.setPreferredSize(new java.awt.Dimension(408, 504));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Height (Cm)");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Weight (Kg)");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Blood Group");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Date of Birth");

        jTextField13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextField14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Place of Birth");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 112, 54));

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("State of Origin");

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundCorner4Layout = new javax.swing.GroupLayout(roundCorner4);
        roundCorner4.setLayout(roundCorner4Layout);
        roundCorner4Layout.setHorizontalGroup(
            roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField10)
                    .addComponent(jTextField11)
                    .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField14)
                    .addGroup(roundCorner4Layout.createSequentialGroup()
                        .addGroup(roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 271, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addComponent(jTextField3))
                .addContainerGap())
        );
        roundCorner4Layout.setVerticalGroup(
            roundCorner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundCorner4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(12, 12, 12)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jLabel38)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel23.setBackground(java.awt.Color.white);
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Permanent Address");

        jTextField16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Present Address");

        jTextField17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("National ID Number");

        jTextField18.setEditable(false);
        jTextField18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Marital Status");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Select Marital Status----", "Single", "Married", "Divorced", "Widow(er)" }));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(jTextField17)
                    .addComponent(jTextField18)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addGap(27, 27, 27)
                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(roundCorner2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundCorner4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundCorner2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(roundCorner4, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Personal Details", jPanel14);

        jPanel15.setBackground(java.awt.Color.white);

        jPanel24.setBackground(java.awt.Color.white);
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel24.setRequestFocusEnabled(false);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Name of next Kin");

        jTextField23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("Address of next Kin");

        jTextField24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("Job of next Kin");

        jTextField25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Phone No of next Kin");

        jTextField26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Spouse Name");

        jTextField27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setText("Spouse Address");

        jTextField28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setText("Spouse Job");

        jTextField37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setText("Add another Spouse");

        jTextField38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField23)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26)
                    .addComponent(jTextField27)
                    .addComponent(jTextField28)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37)
                    .addComponent(jTextField38, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel25.setBackground(java.awt.Color.white);
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel25.setPreferredSize(new java.awt.Dimension(428, 606));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Spouse Address");

        jTextField29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("Spouse Job");

        jTextField30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("Child Name");

        jTextField31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setText("Date of Birth");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setText("Another Child Name");

        jTextField33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setText("Date of Birth");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setText("Another Child Name");

        jTextField35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Date of Birth");

        jDateSearchFrom1.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom1PropertyChange(evt);
            }
        });

        jDateSearchFrom2.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom2PropertyChange(evt);
            }
        });

        jDateSearchFrom3.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom3PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateSearchFrom2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                        .addComponent(jTextField29, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField30, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField31, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField33, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField35, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateSearchFrom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jDateSearchFrom3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateSearchFrom2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateSearchFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56)
                .addGap(18, 18, 18)
                .addComponent(jDateSearchFrom3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel26.setBackground(java.awt.Color.white);
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Father's Name");

        jTextField19.setEditable(false);
        jTextField19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Father's Address");

        jTextField20.setEditable(false);
        jTextField20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Mother's Name");

        jTextField21.setEditable(false);
        jTextField21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Mother's Address");

        jTextField22.setEditable(false);
        jTextField22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Are your parents economically dependent on you?");

        jRadioButton1.setBackground(java.awt.Color.white);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Yes");
        jRadioButton1.setEnabled(false);

        jRadioButton2.setBackground(java.awt.Color.white);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setText("No");
        jRadioButton2.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("if yes please specify what help you provide them");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19)
                    .addComponent(jTextField20)
                    .addComponent(jTextField21)
                    .addComponent(jTextField22, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButton2)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Family Details", jPanel15);

        jPanel16.setBackground(java.awt.Color.white);

        jPanel27.setBackground(java.awt.Color.white);
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setText("Additional Information");

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea5.setRows(5);
        jScrollPane7.setViewportView(jTextArea5);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel67)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBackground(java.awt.Color.white);
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setText("Been Imprisoned");

        jRadioButton3.setBackground(java.awt.Color.white);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton3.setText("Yes");
        jRadioButton3.setEnabled(false);

        jRadioButton4.setBackground(java.awt.Color.white);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton4.setText("No");
        jRadioButton4.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setText("If Yes give details");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setText("Health Condition");

        jRadioButton7.setBackground(java.awt.Color.white);
        jRadioButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton7.setText("Good");
        jRadioButton7.setEnabled(false);

        jRadioButton8.setBackground(java.awt.Color.white);
        jRadioButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton8.setText("Physically Challenged");
        jRadioButton8.setEnabled(false);

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setText("If Yes Give Details");

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea4.setRows(5);
        jScrollPane6.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(48, 48, 48)
                                .addComponent(jRadioButton4))
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jRadioButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel60)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel29.setBackground(java.awt.Color.white);
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setText("Participated in Battles");

        jRadioButton5.setBackground(java.awt.Color.white);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton5.setText("Yes");
        jRadioButton5.setEnabled(false);

        jRadioButton6.setBackground(java.awt.Color.white);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton6.setText("No");
        jRadioButton6.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setText("If Yes Give Details");

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setText("Date of Participation");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setText("Place of Participation");

        jTextField32.setEditable(false);
        jTextField32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jDateSearchFrom4.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom4.setEnabled(false);
        jDateSearchFrom4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom4PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel29Layout.createSequentialGroup()
                                    .addComponent(jRadioButton5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton6))
                                .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField32)
                    .addComponent(jDateSearchFrom4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel65)
                .addGap(18, 18, 18)
                .addComponent(jDateSearchFrom4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(281, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Other Information", jPanel16);

        jPanel17.setBackground(java.awt.Color.white);

        jPanel30.setBackground(java.awt.Color.white);
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel81.setText("Primary");

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setText("Location");

        jTextField43.setEditable(false);
        jTextField43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setText("Secondary");

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel84.setText("Location");

        jTextField44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel85.setText("College");

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel86.setText("Location");

        jTextField45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setText("University");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setText("Location");

        jTextField46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel89.setText("Post Graduate");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setText("Location");

        jTextField47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel91.setText("Other");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel92.setText("Location");

        jTextField49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField43)
                    .addComponent(jTextField44)
                    .addComponent(jTextField45)
                    .addComponent(jTextField46)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82)
                            .addComponent(jLabel84)
                            .addComponent(jLabel85)
                            .addComponent(jLabel88)
                            .addComponent(jLabel89)
                            .addComponent(jLabel90)
                            .addComponent(jLabel91)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 193, Short.MAX_VALUE))
                    .addComponent(jTextField47)
                    .addComponent(jTextField49))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86)
                .addGap(18, 18, 18)
                .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel31.setBackground(java.awt.Color.white);
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel31.setPreferredSize(new java.awt.Dimension(354, 669));

        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel106.setText("Primary");

        jTextField48.setEditable(false);
        jTextField48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel107.setText("Secondary");

        jTextField50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel108.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel108.setText("College");

        jTextField51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel109.setText("University");

        jTextField52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel110.setText("Post Graduate");

        jTextField53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel111.setText("Certificate Issued");

        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel112.setText("Other");

        jTextField54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField54)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(jTextField52, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField51, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField50, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField48, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel111)
                .addGap(18, 18, 18)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel107)
                .addGap(18, 18, 18)
                .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel108)
                .addGap(18, 18, 18)
                .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel109)
                .addGap(18, 18, 18)
                .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel110)
                .addGap(18, 18, 18)
                .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel112)
                .addGap(30, 30, 30)
                .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(java.awt.Color.white);
        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setText("Level");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setText("Primary");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setText("Name of Institution");

        jTextField34.setEditable(false);
        jTextField34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setText("Secondary");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel72.setText("Name of Institution");

        jTextField36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setText("College");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setText("Name of Institution");

        jTextField39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setText("University");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setText("Name of Institution");

        jTextField40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel77.setText("Post Graduate");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setText("Name of Institution");

        jTextField41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setText("Other");

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setText("Name of Institution");

        jTextField42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField34)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73)
                            .addComponent(jLabel74)
                            .addComponent(jLabel77)
                            .addComponent(jLabel78)
                            .addComponent(jLabel79)
                            .addComponent(jLabel80)
                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 138, Short.MAX_VALUE))
                    .addComponent(jTextField36)
                    .addComponent(jTextField39)
                    .addComponent(jTextField40)
                    .addComponent(jTextField41)
                    .addComponent(jTextField42))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel34.setBackground(java.awt.Color.white);
        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel34.setPreferredSize(new java.awt.Dimension(354, 669));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel93.setText("Inclusive Date");

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel95.setText("To");

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel96.setText("Secondary From");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel97.setText("To");

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel98.setText("College From");

        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel99.setText("To");

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel100.setText("University From");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel101.setText("To");

        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel102.setText("Post Graduate From");

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel103.setText("To");

        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel104.setText("Other From");

        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel105.setText("To");

        jDateSearchFrom7.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom7PropertyChange(evt);
            }
        });

        jDateSearchFrom8.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom8PropertyChange(evt);
            }
        });

        jDateSearchFrom9.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom9.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom9PropertyChange(evt);
            }
        });

        jDateSearchFrom10.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom10.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom10PropertyChange(evt);
            }
        });

        jDateSearchFrom11.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom11.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom11PropertyChange(evt);
            }
        });

        jDateSearchFrom12.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom12.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom12PropertyChange(evt);
            }
        });

        jDateSearchFrom13.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom13.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom13PropertyChange(evt);
            }
        });

        jDateSearchFrom14.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom14.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom14PropertyChange(evt);
            }
        });

        jDateSearchFrom15.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom15.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom15PropertyChange(evt);
            }
        });

        jDateSearchFrom16.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom16.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom16PropertyChange(evt);
            }
        });

        jLabel156.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel156.setText("Primary From");

        jTextField15.setEditable(false);
        jTextField15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField122.setEditable(false);
        jTextField122.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel96)
                            .addComponent(jLabel98)
                            .addComponent(jLabel100)
                            .addComponent(jLabel102)
                            .addComponent(jLabel104))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel99)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel105)))
                            .addComponent(jLabel97)
                            .addComponent(jLabel101))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jDateSearchFrom16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jDateSearchFrom12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateSearchFrom13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel34Layout.createSequentialGroup()
                                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jDateSearchFrom14, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(jDateSearchFrom15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jDateSearchFrom11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jDateSearchFrom10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                        .addComponent(jDateSearchFrom8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateSearchFrom7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateSearchFrom9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel156)
                                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel95)
                                            .addComponent(jTextField122))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(17, 17, 17))))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel93)
                .addGap(35, 35, 35)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(jLabel156)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(jLabel95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateSearchFrom8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateSearchFrom9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSearchFrom10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jLabel101))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateSearchFrom13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSearchFrom11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jLabel103))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateSearchFrom12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSearchFrom14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateSearchFrom16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSearchFrom15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Educational Background", jPanel17);

        jPanel18.setBackground(java.awt.Color.white);

        jPanel32.setBackground(java.awt.Color.white);
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel113.setText("Police Work Experience");

        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel114.setText("Type of Work /Occupation");

        jTextField55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel115.setText("Location/Place");

        jTextField56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel116.setText("Rank");

        jTextField57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel117.setText("From");

        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel118.setText("To");

        jDateSearchFrom17.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom17.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom17PropertyChange(evt);
            }
        });

        jDateSearchFrom18.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom18.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom18PropertyChange(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel119.setText("Type of Work/Occupation");

        jTextField58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel120.setText("Location/Place");

        jTextField59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel121.setText("Rank");

        jTextField60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel122.setText("From");

        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel123.setText("To");

        jDateSearchFrom19.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom19.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom19PropertyChange(evt);
            }
        });

        jDateSearchFrom20.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom20.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom20PropertyChange(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel124.setText("Date Inclusively");

        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel125.setText("Date Inclusively");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel124)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateSearchFrom20, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel122))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel123)
                                    .addComponent(jDateSearchFrom19, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel125))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField55)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateSearchFrom18, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel117))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel118)
                                    .addComponent(jDateSearchFrom17, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField56)
                            .addComponent(jTextField57)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel113)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel115)
                                    .addComponent(jLabel116)
                                    .addComponent(jLabel119)
                                    .addComponent(jLabel120)
                                    .addComponent(jLabel121)
                                    .addComponent(jTextField58)
                                    .addComponent(jTextField59)
                                    .addComponent(jTextField60, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel114)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel115)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel116)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel124)
                .addGap(9, 9, 9)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel118)
                    .addComponent(jLabel117))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateSearchFrom18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSearchFrom17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel119)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel120)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel121)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel125)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel122)
                            .addComponent(jLabel123))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateSearchFrom20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateSearchFrom19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.setBackground(java.awt.Color.white);
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel126.setText("Civil Work Experience");

        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel127.setText("Type of Work Experience");

        jTextField61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel128.setText(" Description Location/Place");

        jTextField62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel129.setText("Provided By");

        jTextField63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel130.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel130.setText("Duration");

        jLabel131.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel131.setText("From");

        jDateSearchFrom21.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom21.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom21PropertyChange(evt);
            }
        });

        jDateSearchFrom22.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom22.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom22PropertyChange(evt);
            }
        });

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel133.setText("Location");

        jTextField64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel134.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel134.setText("To");

        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel132.setText("Type of Work Experience");

        jTextField65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel135.setText(" Description Location/Place");

        jTextField66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel136.setText("Provided By");

        jTextField67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel137.setText("Location");

        jTextField68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel138.setText("Duration");

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel139.setText("From");

        jDateSearchFrom23.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom23.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom23PropertyChange(evt);
            }
        });

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel140.setText("To");

        jDateSearchFrom24.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom24.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom24PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel127)
                                    .addComponent(jLabel128)
                                    .addComponent(jLabel129))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField61)
                            .addComponent(jTextField62)
                            .addComponent(jTextField63))
                        .addContainerGap())
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel133)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addComponent(jTextField64)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jDateSearchFrom21, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateSearchFrom22, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel130)
                            .addComponent(jLabel131))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel134)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel132)
                                    .addComponent(jLabel135)
                                    .addComponent(jLabel136))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField65)
                            .addComponent(jTextField66)
                            .addComponent(jTextField67)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel137)
                                .addGap(333, 333, 333))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                                .addComponent(jTextField68)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jDateSearchFrom23, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateSearchFrom24, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel138)
                                    .addComponent(jLabel139))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel140)
                                .addGap(158, 158, 158)))
                        .addContainerGap())))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel126)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel127)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel128)
                .addGap(11, 11, 11)
                .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel129)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel133)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel131)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel134)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel132)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel135)
                .addGap(11, 11, 11)
                .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel136)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel137)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel138)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel139)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel140)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel36.setBackground(java.awt.Color.white);
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel141.setText("Military Work Experience");

        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel142.setText("Type of Work Experience");

        jTextField69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel143.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel143.setText(" Description Location/Place");

        jTextField70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel144.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel144.setText("Provided By");

        jTextField71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel145.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel145.setText("Location");

        jTextField72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel146.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel146.setText("Duration");

        jLabel147.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel147.setText("From");

        jDateSearchFrom25.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom25.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom25PropertyChange(evt);
            }
        });

        jLabel148.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel148.setText("To");

        jDateSearchFrom26.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom26.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom26PropertyChange(evt);
            }
        });

        jLabel149.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel149.setText("Type of Work Experience");

        jTextField73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel150.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel150.setText(" Description Location/Place");

        jTextField74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel151.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel151.setText("Provided By");

        jTextField75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel152.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel152.setText("Location");

        jTextField76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel153.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel153.setText("Duration");

        jLabel154.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel154.setText("From");

        jDateSearchFrom27.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom27.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom27PropertyChange(evt);
            }
        });

        jLabel155.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel155.setText("To");

        jDateSearchFrom28.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom28.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom28PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel142)
                            .addComponent(jLabel143)
                            .addComponent(jLabel144)
                            .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jTextField72)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel146)
                            .addComponent(jLabel147))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel148)
                        .addGap(181, 181, 181))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField69)
                            .addComponent(jTextField70)
                            .addComponent(jTextField71)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jDateSearchFrom25, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateSearchFrom26, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jTextField76)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel153)
                            .addComponent(jLabel154))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel155)
                        .addGap(158, 158, 158))
                    .addComponent(jTextField73)
                    .addComponent(jTextField74)
                    .addComponent(jTextField75)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jDateSearchFrom27, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateSearchFrom28, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel145)
                            .addComponent(jLabel149)
                            .addComponent(jLabel150)
                            .addComponent(jLabel151)
                            .addComponent(jLabel152))
                        .addGap(243, 243, 243))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel141)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel142)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel143)
                .addGap(11, 11, 11)
                .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel144)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel145)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel147)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel149)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel150)
                .addGap(11, 11, 11)
                .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel151)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel152)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel153)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel154)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Work Experience", jPanel18);

        jPanel19.setBackground(java.awt.Color.white);

        jPanel37.setBackground(java.awt.Color.white);
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel157.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel157.setText("Police Training Details");

        jLabel158.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel158.setText("Training/Course Undertaken");

        jTextField77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel159.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel159.setText("Module/Description");

        jTextField78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel160.setText("Provided By");

        jTextField79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel161.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel161.setText("Qualified (Yes/No)");

        jLabel162.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel162.setText("Period of Training From");

        jDateSearchFrom29.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom29.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom29PropertyChange(evt);
            }
        });

        jDateSearchFrom30.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom30.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom30PropertyChange(evt);
            }
        });

        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel163.setText("Location");

        jTextField80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel164.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel164.setText("To");

        jLabel165.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel165.setText("Training/Course Undertaken");

        jTextField81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField81ActionPerformed(evt);
            }
        });

        jLabel166.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel166.setText("Module/Description");

        jTextField82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField82ActionPerformed(evt);
            }
        });

        jLabel167.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel167.setText("Provided By");

        jTextField83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel168.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel168.setText("Location");

        jTextField84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel169.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel169.setText("Qualified (Yes/ No)");

        jLabel170.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel170.setText("From");

        jDateSearchFrom31.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom31.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom31PropertyChange(evt);
            }
        });

        jLabel171.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel171.setText("To");

        jDateSearchFrom32.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom32.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom32PropertyChange(evt);
            }
        });

        jTextField85.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jTextField81)
                        .addContainerGap())
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel157)
                                    .addComponent(jLabel158)
                                    .addComponent(jLabel159)
                                    .addComponent(jLabel160))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField77)
                            .addComponent(jTextField78)
                            .addComponent(jTextField79))
                        .addContainerGap())
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jDateSearchFrom29, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateSearchFrom30, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel162)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel164)
                        .addGap(168, 168, 168))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField82)
                            .addComponent(jTextField83)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateSearchFrom31, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel170))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel171)
                                    .addComponent(jDateSearchFrom32, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField80, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField85))
                        .addContainerGap())
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel168)
                            .addComponent(jLabel166)
                            .addComponent(jLabel167)
                            .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel163)
                            .addComponent(jLabel161)
                            .addComponent(jLabel169))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField86, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField84))
                        .addGap(12, 12, 12))))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel157)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel158)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel159)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel160)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel163)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel161)
                .addGap(4, 4, 4)
                .addComponent(jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel162)
                        .addGap(4, 4, 4)
                        .addComponent(jDateSearchFrom29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel164)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel165)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel166)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel167)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel168)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel169)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel171))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel170)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateSearchFrom31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSearchFrom32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel38.setBackground(java.awt.Color.white);
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel172.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel172.setText("Military Training Details");

        jLabel173.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel173.setText("Training/Course Undertaken");

        jTextField87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel174.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel174.setText("Module/Description");

        jTextField88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel175.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel175.setText("Provided By");

        jTextField89.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel176.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel176.setText("Qualified (Yes/No)");

        jLabel177.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel177.setText("Period of Training From");

        jDateSearchFrom33.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom33.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom33PropertyChange(evt);
            }
        });

        jDateSearchFrom34.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom34.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom34PropertyChange(evt);
            }
        });

        jLabel178.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel178.setText("Location");

        jTextField90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel179.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel179.setText("To");

        jLabel180.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel180.setText("Training/Course Undertaken");

        jTextField91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField91ActionPerformed(evt);
            }
        });

        jLabel181.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel181.setText("Module/Description");

        jTextField92.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField92ActionPerformed(evt);
            }
        });

        jLabel182.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel182.setText("Provided By");

        jTextField93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel183.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel183.setText("Location");

        jTextField94.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel184.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel184.setText("Qualified (Yes/ No)");

        jLabel185.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel185.setText("From");

        jDateSearchFrom35.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom35.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom35PropertyChange(evt);
            }
        });

        jLabel186.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel186.setText("To");

        jDateSearchFrom36.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom36.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom36PropertyChange(evt);
            }
        });

        jTextField95.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField96.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jTextField91)
                        .addContainerGap())
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel172)
                                    .addComponent(jLabel173)
                                    .addComponent(jLabel174)
                                    .addComponent(jLabel175))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField87)
                            .addComponent(jTextField88)
                            .addComponent(jTextField89))
                        .addContainerGap())
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jDateSearchFrom33, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateSearchFrom34, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel177)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel179)
                        .addGap(168, 168, 168))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField92)
                            .addComponent(jTextField93)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateSearchFrom35, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel185))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel186)
                                    .addComponent(jDateSearchFrom36, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField90, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField95))
                        .addContainerGap())
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel183)
                            .addComponent(jLabel181)
                            .addComponent(jLabel182)
                            .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel178)
                            .addComponent(jLabel176)
                            .addComponent(jLabel184))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField96, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField94))
                        .addGap(12, 12, 12))))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel172)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel173)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel174)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel175)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel178)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel176)
                .addGap(4, 4, 4)
                .addComponent(jTextField95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel177)
                        .addGap(4, 4, 4)
                        .addComponent(jDateSearchFrom33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel179)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateSearchFrom34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel180)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel181)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel182)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel183)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel184)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel186))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel185)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateSearchFrom35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSearchFrom36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel39.setBackground(java.awt.Color.white);
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel94.setText("Specialized/Technical Qualifications");

        jTextField97.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField98.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField99.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField100.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField101.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField97)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addComponent(jTextField98)
                    .addComponent(jTextField99)
                    .addComponent(jTextField100)
                    .addComponent(jTextField101))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel94)
                .addGap(18, 18, 18)
                .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Training Details", jPanel19);

        jPanel20.setBackground(java.awt.Color.white);

        jPanel41.setBackground(java.awt.Color.white);
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel192.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel192.setText("Literacy/Language");

        jLabel193.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel193.setText("Language");

        jLabel194.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel194.setText("Arabic");

        jLabel195.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel195.setText("English");

        jLabel196.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel196.setText("Other Languages(s)");

        jTextField104.setEditable(false);
        jTextField104.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField105.setEditable(false);
        jTextField105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel40.setBackground(java.awt.Color.white);

        jCheckBox7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox7.setText("Speak");
        jCheckBox7.setEnabled(false);

        jCheckBox8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox8.setText("Speak");
        jCheckBox8.setEnabled(false);

        jCheckBox9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox9.setText("Speak");
        jCheckBox9.setEnabled(false);

        jCheckBox10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox10.setText("Speak");
        jCheckBox10.setEnabled(false);
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox10)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox7))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jCheckBox7)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox8)
                .addGap(51, 51, 51)
                .addComponent(jCheckBox9)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox10)
                .addContainerGap())
        );

        jPanel43.setBackground(java.awt.Color.white);

        jCheckBox11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox11.setText("Read");
        jCheckBox11.setEnabled(false);

        jCheckBox12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox12.setText("Read");
        jCheckBox12.setEnabled(false);
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

        jCheckBox13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox13.setText("Read");
        jCheckBox13.setEnabled(false);
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        jCheckBox14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox14.setText("Read");
        jCheckBox14.setEnabled(false);
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox12)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox13)
                    .addComponent(jCheckBox14))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jCheckBox11)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox12)
                .addGap(58, 58, 58)
                .addComponent(jCheckBox13)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox14)
                .addContainerGap())
        );

        jPanel42.setBackground(java.awt.Color.white);

        jCheckBox15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox15.setText("Write");
        jCheckBox15.setEnabled(false);

        jCheckBox16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox16.setText("Write");
        jCheckBox16.setEnabled(false);
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });

        jCheckBox17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox17.setText("Write");
        jCheckBox17.setEnabled(false);
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        jCheckBox18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox18.setText("Write");
        jCheckBox18.setEnabled(false);
        jCheckBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox18)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox15))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addComponent(jCheckBox15)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox16)
                .addGap(55, 55, 55)
                .addComponent(jCheckBox17)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox18)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel196)
                                    .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField105, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                    .addComponent(jTextField104))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                                .addComponent(jLabel192)
                                .addGap(71, 71, 71))))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel195)
                            .addComponent(jLabel194))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel41Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel192)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel193)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel194)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel195)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel196)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jTextField105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Languages", jPanel20);

        jPanel21.setBackground(java.awt.Color.white);

        jPanel44.setBackground(java.awt.Color.white);
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel187.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel187.setText("Weapon No 1");

        jLabel188.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel188.setText("Calibre");

        jTextField102.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel189.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel189.setText("Type of weapon/Rifle,Pistol etc.");

        jTextField103.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel190.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel190.setText("Serial Number");

        jTextField106.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel191.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel191.setText("Number of Ammunition");

        jTextField107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel197.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel197.setText("Weapon Provided By");

        jTextField108.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField108ActionPerformed(evt);
            }
        });

        jLabel198.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel198.setText("Location Received");

        jTextField109.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel199.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel199.setText("Date Received");

        jDateSearchFrom37.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom37.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom37PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel44Layout.createSequentialGroup()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel188))
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel189))
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel190))
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel191))
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel197))
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel198))
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel199))
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 115, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateSearchFrom37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField109)
                            .addComponent(jTextField108)
                            .addComponent(jTextField107)
                            .addComponent(jTextField106)
                            .addComponent(jTextField103)
                            .addComponent(jTextField102, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel187)
                .addGap(17, 17, 17)
                .addComponent(jLabel188)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel189)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel190)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel191)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel197)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel198)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel199)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateSearchFrom37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel45.setBackground(java.awt.Color.white);
        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel200.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel200.setText("Calibre");

        jTextField110.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel201.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel201.setText("Type of weapon/Rifle,Pistol etc.");

        jTextField111.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel202.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel202.setText("Serial Number");

        jTextField112.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel203.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel203.setText("Number of Ammunition");

        jTextField113.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel204.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel204.setText("Weapon Provided By");

        jTextField114.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField114ActionPerformed(evt);
            }
        });

        jLabel205.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel205.setText("Location Received");

        jTextField115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel206.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel206.setText("Date Received");

        jDateSearchFrom38.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom38.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom38PropertyChange(evt);
            }
        });

        jLabel214.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel214.setText("Weapon No 2");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel200)
                            .addComponent(jLabel201)
                            .addComponent(jLabel202)
                            .addComponent(jLabel203)
                            .addComponent(jLabel204)
                            .addComponent(jLabel205)
                            .addComponent(jLabel206))
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(jDateSearchFrom38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField115)
                    .addComponent(jTextField114)
                    .addComponent(jTextField113)
                    .addComponent(jTextField112)
                    .addComponent(jTextField111)
                    .addComponent(jTextField110, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel214, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel214)
                .addGap(18, 18, 18)
                .addComponent(jLabel200)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel201)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel202)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel203)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel204)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel205)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel206)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateSearchFrom38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel46.setBackground(java.awt.Color.white);
        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel207.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel207.setText("Calibre");

        jTextField116.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel208.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel208.setText("Type of weapon/Rifle,Pistol etc.");

        jTextField117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel209.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel209.setText("Serial Number");

        jTextField118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel210.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel210.setText("Number of Ammunition");

        jTextField119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel211.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel211.setText("Weapon Provided By");

        jTextField120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField120ActionPerformed(evt);
            }
        });

        jLabel212.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel212.setText("Location Received");

        jTextField121.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel213.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel213.setText("Date Received");

        jDateSearchFrom39.setDateFormatString("yyy-MM-dd");
        jDateSearchFrom39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateSearchFrom39.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateSearchFrom39PropertyChange(evt);
            }
        });

        jLabel215.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel215.setText("Weapon No 3");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel207)
                            .addComponent(jLabel208)
                            .addComponent(jLabel209)
                            .addComponent(jLabel210)
                            .addComponent(jLabel211)
                            .addComponent(jLabel212)
                            .addComponent(jLabel213))
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(jDateSearchFrom39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField121)
                    .addComponent(jTextField120)
                    .addComponent(jTextField119)
                    .addComponent(jTextField118)
                    .addComponent(jTextField117)
                    .addComponent(jTextField116, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel215, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel215)
                .addGap(16, 16, 16)
                .addComponent(jLabel207)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel208)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField117, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel209)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField118, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel210)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel211)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel212)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField121, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel213)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateSearchFrom39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Issued Firearm Details", jPanel21);

        jPanel22.setBackground(java.awt.Color.white);

        jPanel47.setBackground(java.awt.Color.white);
        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextPane1.setText("I certify that the above information furnished by me is true, complete and correct to the best of my knowledge and belief.I understand that any misinterpresentation or material or Omission readers me liable to Termination of employment and dismissal.");
        jScrollPane8.setViewportView(jTextPane1);

        jCheckBox19.setBackground(java.awt.Color.white);
        jCheckBox19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox19.setText("I consent");

        jButton4.setBackground(new java.awt.Color(0, 112, 54));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Edit");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel219.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(0, 112, 54));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel219, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox19)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel219))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        jPanel48.setBackground(java.awt.Color.white);
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel221.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel221.setText("Medical Fitness");

        jLabel222.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel222.setText("Injury resulting in physical challenges,if any?");

        jLabel223.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel223.setText("Injury Suffered");

        jTextField126.setEditable(false);
        jTextField126.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel224.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel224.setText("Physical Challenge");

        jTextField127.setEditable(false);
        jTextField127.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel225.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel225.setText("Remarks");

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane9.setViewportView(jTextArea7);

        jRadioButton11.setBackground(java.awt.Color.white);
        jRadioButton11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton11.setText("Good");
        jRadioButton11.setEnabled(false);

        jRadioButton12.setBackground(java.awt.Color.white);
        jRadioButton12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton12.setText("Physically Challenged");
        jRadioButton12.setEnabled(false);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jRadioButton11)
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButton12))
                    .addComponent(jTextField127, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField126, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel221)
                    .addComponent(jLabel222)
                    .addComponent(jLabel223)
                    .addComponent(jLabel224)
                    .addComponent(jLabel225)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel221)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12))
                .addGap(18, 18, 18)
                .addComponent(jLabel222)
                .addGap(18, 18, 18)
                .addComponent(jLabel223)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel224)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel225)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(915, Short.MAX_VALUE)))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(257, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Medical Fitness", jPanel22);

        jScrollPane1.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        String item = (String) jComboBox4.getSelectedItem();
        Object o = subItems.get(item);

        if (o == null) {
            jComboBox1.setModel(new DefaultComboBoxModel<>());

        } else {
            jComboBox1.setModel(new DefaultComboBoxModel<>((String[]) o));

        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jDateSearchFrom1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom1PropertyChange

    private void jDateSearchFrom3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom3PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom3PropertyChange

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jDateSearchFrom4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom4PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom4PropertyChange

    private void jDateSearchFrom7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom7PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom7PropertyChange

    private void jDateSearchFrom8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom8PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom8PropertyChange

    private void jDateSearchFrom9PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom9PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom9PropertyChange

    private void jDateSearchFrom10PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom10PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom10PropertyChange

    private void jDateSearchFrom11PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom11PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom11PropertyChange

    private void jDateSearchFrom12PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom12PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom12PropertyChange

    private void jDateSearchFrom13PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom13PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom13PropertyChange

    private void jDateSearchFrom14PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom14PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom14PropertyChange

    private void jDateSearchFrom15PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom15PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom15PropertyChange

    private void jDateSearchFrom16PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom16PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom16PropertyChange

    private void jDateSearchFrom17PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom17PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom17PropertyChange

    private void jDateSearchFrom18PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom18PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom18PropertyChange

    private void jDateSearchFrom19PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom19PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom19PropertyChange

    private void jDateSearchFrom20PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom20PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom20PropertyChange

    private void jDateSearchFrom21PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom21PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom21PropertyChange

    private void jDateSearchFrom22PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom22PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom22PropertyChange

    private void jDateSearchFrom23PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom23PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom23PropertyChange

    private void jDateSearchFrom24PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom24PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom24PropertyChange

    private void jDateSearchFrom25PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom25PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom25PropertyChange

    private void jDateSearchFrom26PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom26PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom26PropertyChange

    private void jDateSearchFrom27PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom27PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom27PropertyChange

    private void jDateSearchFrom28PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom28PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom28PropertyChange

    private void jDateSearchFrom29PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom29PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom29PropertyChange

    private void jDateSearchFrom30PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom30PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom30PropertyChange

    private void jTextField81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField81ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField81ActionPerformed

    private void jTextField82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField82ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField82ActionPerformed

    private void jDateSearchFrom31PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom31PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom31PropertyChange

    private void jDateSearchFrom32PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom32PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom32PropertyChange

    private void jDateSearchFrom33PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom33PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom33PropertyChange

    private void jDateSearchFrom34PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom34PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom34PropertyChange

    private void jTextField91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField91ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField91ActionPerformed

    private void jTextField92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField92ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField92ActionPerformed

    private void jDateSearchFrom35PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom35PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom35PropertyChange

    private void jDateSearchFrom36PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom36PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom36PropertyChange

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void jTextField108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField108ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField108ActionPerformed

    private void jDateSearchFrom37PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom37PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom37PropertyChange

    private void jTextField114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField114ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField114ActionPerformed

    private void jDateSearchFrom38PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom38PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom38PropertyChange

    private void jTextField120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField120ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField120ActionPerformed

    private void jDateSearchFrom39PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom39PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom39PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            // TODO add your handling code here:

           editOfficer();
        } catch (SQLException ex) {
            Logger.getLogger(FragmentEditEnrollment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jDateSearchFrom2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateSearchFrom2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateSearchFrom2PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateSearchFrom1;
    private com.toedter.calendar.JDateChooser jDateSearchFrom10;
    private com.toedter.calendar.JDateChooser jDateSearchFrom11;
    private com.toedter.calendar.JDateChooser jDateSearchFrom12;
    private com.toedter.calendar.JDateChooser jDateSearchFrom13;
    private com.toedter.calendar.JDateChooser jDateSearchFrom14;
    private com.toedter.calendar.JDateChooser jDateSearchFrom15;
    private com.toedter.calendar.JDateChooser jDateSearchFrom16;
    private com.toedter.calendar.JDateChooser jDateSearchFrom17;
    private com.toedter.calendar.JDateChooser jDateSearchFrom18;
    private com.toedter.calendar.JDateChooser jDateSearchFrom19;
    private com.toedter.calendar.JDateChooser jDateSearchFrom2;
    private com.toedter.calendar.JDateChooser jDateSearchFrom20;
    private com.toedter.calendar.JDateChooser jDateSearchFrom21;
    private com.toedter.calendar.JDateChooser jDateSearchFrom22;
    private com.toedter.calendar.JDateChooser jDateSearchFrom23;
    private com.toedter.calendar.JDateChooser jDateSearchFrom24;
    private com.toedter.calendar.JDateChooser jDateSearchFrom25;
    private com.toedter.calendar.JDateChooser jDateSearchFrom26;
    private com.toedter.calendar.JDateChooser jDateSearchFrom27;
    private com.toedter.calendar.JDateChooser jDateSearchFrom28;
    private com.toedter.calendar.JDateChooser jDateSearchFrom29;
    private com.toedter.calendar.JDateChooser jDateSearchFrom3;
    private com.toedter.calendar.JDateChooser jDateSearchFrom30;
    private com.toedter.calendar.JDateChooser jDateSearchFrom31;
    private com.toedter.calendar.JDateChooser jDateSearchFrom32;
    private com.toedter.calendar.JDateChooser jDateSearchFrom33;
    private com.toedter.calendar.JDateChooser jDateSearchFrom34;
    private com.toedter.calendar.JDateChooser jDateSearchFrom35;
    private com.toedter.calendar.JDateChooser jDateSearchFrom36;
    private com.toedter.calendar.JDateChooser jDateSearchFrom37;
    private com.toedter.calendar.JDateChooser jDateSearchFrom38;
    private com.toedter.calendar.JDateChooser jDateSearchFrom39;
    private com.toedter.calendar.JDateChooser jDateSearchFrom4;
    private com.toedter.calendar.JDateChooser jDateSearchFrom7;
    private com.toedter.calendar.JDateChooser jDateSearchFrom8;
    private com.toedter.calendar.JDateChooser jDateSearchFrom9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField100;
    private javax.swing.JTextField jTextField101;
    private javax.swing.JTextField jTextField102;
    private javax.swing.JTextField jTextField103;
    private javax.swing.JTextField jTextField104;
    private javax.swing.JTextField jTextField105;
    private javax.swing.JTextField jTextField106;
    private javax.swing.JTextField jTextField107;
    private javax.swing.JTextField jTextField108;
    private javax.swing.JTextField jTextField109;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField110;
    private javax.swing.JTextField jTextField111;
    private javax.swing.JTextField jTextField112;
    private javax.swing.JTextField jTextField113;
    private javax.swing.JTextField jTextField114;
    private javax.swing.JTextField jTextField115;
    private javax.swing.JTextField jTextField116;
    private javax.swing.JTextField jTextField117;
    private javax.swing.JTextField jTextField118;
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField120;
    private javax.swing.JTextField jTextField121;
    private javax.swing.JTextField jTextField122;
    private javax.swing.JTextField jTextField126;
    private javax.swing.JTextField jTextField127;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JTextField jTextField85;
    private javax.swing.JTextField jTextField86;
    private javax.swing.JTextField jTextField87;
    private javax.swing.JTextField jTextField88;
    private javax.swing.JTextField jTextField89;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField90;
    private javax.swing.JTextField jTextField91;
    private javax.swing.JTextField jTextField92;
    private javax.swing.JTextField jTextField93;
    private javax.swing.JTextField jTextField94;
    private javax.swing.JTextField jTextField95;
    private javax.swing.JTextField jTextField96;
    private javax.swing.JTextField jTextField97;
    private javax.swing.JTextField jTextField98;
    private javax.swing.JTextField jTextField99;
    private javax.swing.JTextPane jTextPane1;
    private SwingClass.RoundCorner roundCorner2;
    private SwingClass.RoundCorner roundCorner4;
    // End of variables declaration//GEN-END:variables

    private void editOfficer() throws SQLException {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStmt = null;
        PreparedStatement preparedStmt2 = null;
        PreparedStatement preparedStmt3 = null;
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        Statement stmt = null;
        Statement stmt1 = null;
        Statement stmt2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        Statement st = null;
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");

        String police = jTextField1.getText();
        String state = jComboBox4.getSelectedItem().toString();
        String county = jComboBox1.getSelectedItem().toString();
        String rank = jComboBox5.getSelectedItem().toString();
        String letter = jLabel216.getText();
        String station = jTextField12.getText();
        String retire = null;
        if (jRadioButton9.isSelected()) {
            retire = "Retired";
        } else if (jRadioButton10.isSelected()) {
            retire = "Not Retired";
        }
        String first = jTextField6.getText();
        String last = jTextField5.getText();
        String middle = jTextField4.getText();
        String other = jTextField9.getText();
        String gender = jComboBox2.getSelectedItem().toString();
        String position = jTextField7.getText();
        String email = jTextField8.getText();
        String placeBirth = jTextField10.getText();
        String stateOrigin = jTextField11.getText();
        String permanent = jTextField16.getText();
        String present = jTextField17.getText();
        String national = jTextField18.getText();
        String marital = jComboBox3.getSelectedItem().toString();
        String height = jTextField13.getText();
        String weight = jTextField14.getText();
        String blood = jTextField3.getText();
        String dateOfBirth = jTextField2.getText();
        String father = jTextField19.getText();
        String father_address = jTextField20.getText();
        String mother = jTextField21.getText();
        String mother_address = jTextField22.getText();
        String economical = null;
        String economical_details = jTextArea1.getText();
        if (jRadioButton1.isSelected()) {
            economical = "Yes";
        } else if (jRadioButton2.isSelected()) {
            economical = "No";
        }
        String nameKin = jTextField23.getText();
        String addressKin = jTextField24.getText();
        String jobKin = jTextField25.getText();
        String phoneKin = jTextField26.getText();
        String spouseName = jTextField27.getText();
        String spouseAddress = jTextField28.getText();
        String spouseJob = jTextField37.getText();
        String anotherSpouse = jTextField38.getText();
        String anotherAddress = jTextField29.getText();
        String anotherJob = jTextField30.getText();
        String childName = jTextField31.getText();
        Date birthdate = jDateSearchFrom2.getDate();

        String childdate = dcn.format(birthdate);
        String anotherChild = jTextField33.getText();
        Date anotherdate = jDateSearchFrom1.getDate();
        String datebirth = dcn.format(anotherdate);
        String child3 = jTextField35.getText();
        Date birth2 = jDateSearchFrom3.getDate();
        String birth3 = dcn.format(birth2);
        String imprisoned = null;
        if (jRadioButton3.isSelected()) {
            imprisoned = "Yes";
        } else if (jRadioButton4.isSelected()) {
            imprisoned = "No";
        }
        String imprisonment_details = jTextArea2.getText();
        String health_condition = null;
        if (jRadioButton7.isSelected()) {
            health_condition = "Good";

        } else if (jRadioButton8.isSelected()) {
            health_condition = "Physically Challenged";
        }
        String health_details = jTextArea4.getText();
        String battles = null;
        if (jRadioButton5.isSelected()) {
            battles = "Yes";
        } else if (jRadioButton6.isSelected()) {
            battles = "No";
        }
        String battle_details = jTextArea3.getText();
        Date date1 = jDateSearchFrom4.getDate();
        String participation_date = dcn.format(date1);
        String place_of_participation = jTextField32.getText();
        String additional_info = jTextArea5.getText();
        String primary_institution = jTextField34.getText();
        String secondary_institution = jTextField36.getText();
        String college_institution = jTextField39.getText();
        String university_institution = jTextField40.getText();
        String post_graduate = jTextField41.getText();
        String other_institution = jTextField42.getText();
        String primary_location = jTextField43.getText();
        String secondary_location = jTextField44.getText();
        String college_location = jTextField45.getText();
        String university_location = jTextField46.getText();
        String post_graduate_location = jTextField47.getText();
        String other_location = jTextField49.getText();
        //Date date36 = jDateSearchFrom6.getDate();
        String primary_from = jTextField15.getText();
        // Date date37 = jDateSearchFrom5.getDate();
        String primary_to = jTextField122.getText();
        String primary_certificate = jTextField48.getText();
        String secondary_certificate = jTextField50.getText();
        String college_certificate = jTextField51.getText();
        String university_certificate = jTextField52.getText();
        String post_graduate_certificate = jTextField53.getText();
        String other_certificate = jTextField54.getText();
        Date date3 = jDateSearchFrom8.getDate();
        String secondary_from = dcn.format(date3);
        Date date4 = jDateSearchFrom7.getDate();
        String secondary_to = dcn.format(date4);
        Date date5 = jDateSearchFrom9.getDate();
        String college_from = dcn.format(date5);
        Date date6 = jDateSearchFrom10.getDate();
        String college_to = dcn.format(date6);
        Date date7 = jDateSearchFrom13.getDate();
        String university_from = dcn.format(date7);
        Date date8 = jDateSearchFrom11.getDate();
        String university_to = dcn.format(date8);
        Date date9 = jDateSearchFrom12.getDate();
        String post_graduate_from = dcn.format(date9);
        Date date10 = jDateSearchFrom14.getDate();
        String post_graduate_to = dcn.format(date10);
        Date date11 = jDateSearchFrom16.getDate();
        String other_from = dcn.format(date11);
        Date date12 = jDateSearchFrom15.getDate();
        String other_to = dcn.format(date12);
        String police_work = jTextField55.getText();
        String police_work_location = jTextField56.getText();
        String police_work_rank = jTextField57.getText();
        Date date13 = jDateSearchFrom18.getDate();
        String police_work_from = dcn.format(date13);
        Date date14 = jDateSearchFrom17.getDate();
        String police_work_to = dcn.format(date14);
        String police_work2 = jTextField58.getText();
        String police_work_location2 = jTextField59.getText();
        Date date15 = jDateSearchFrom20.getDate();
        String police_work_from2 = dcn.format(date15);
        Date date16 = jDateSearchFrom19.getDate();
        String police_work_to2 = dcn.format(date16);
        String police_work_rank2 = jTextField60.getText();
        String civil_work = jTextField61.getText();
        String civil_description = jTextField62.getText();
        String civil_provided_by = jTextField63.getText();
        String civil_work_location = jTextField64.getText();
        Date date17 = jDateSearchFrom21.getDate();
        String civil_duration_from = dcn.format(date17);
        Date date18 = jDateSearchFrom22.getDate();
        String civil_duration_to = dcn.format(date18);
        String civil_work2 = jTextField65.getText();
        String civil_description2 = jTextField66.getText();
        String civil_provided_by2 = jTextField67.getText();
        String civil_work_location2 = jTextField68.getText();
        Date date19 = jDateSearchFrom23.getDate();
        String civil_duration_from2 = dcn.format(date19);
        Date date20 = jDateSearchFrom24.getDate();
        String civil_duration_to2 = dcn.format(date20);
        String military_work = jTextField69.getText();
        String military_description = jTextField70.getText();
        String military_provided_by = jTextField71.getText();
        String military_work_location = jTextField72.getText();
        Date date21 = jDateSearchFrom25.getDate();
        String military_duration_from = dcn.format(date21);
        Date date22 = jDateSearchFrom26.getDate();
        String military_duration_to = dcn.format(date22);
        String military_work2 = jTextField73.getText();
        String military_description2 = jTextField74.getText();
        String military_provided_by2 = jTextField75.getText();
        String military_work_location2 = jTextField76.getText();
        Date date23 = jDateSearchFrom27.getDate();
        String military_duration_from2 = dcn.format(date23);
        Date date24 = jDateSearchFrom28.getDate();
        String military_duration_to2 = dcn.format(date24);
        String police_training = jTextField77.getText();
        String police_training_module = jTextField78.getText();
        String police_training_provided_by = jTextField79.getText();
        String police_training_location = jTextField80.getText();
        String police_training_qualified = jTextField85.getText();
        Date date25 = jDateSearchFrom29.getDate();
        String police_training_period_from = dcn.format(date25);
        Date date26 = jDateSearchFrom30.getDate();
        String police_training_period_to = dcn.format(date26);
        String police_training2 = jTextField81.getText();
        String police_training_module2 = jTextField82.getText();
        String police_training_provided_by2 = jTextField83.getText();
        String police_training_location2 = jTextField84.getText();
        String police_training_qualified2 = jTextField86.getText();
        Date date27 = jDateSearchFrom31.getDate();
        String police_training_period_from2 = dcn.format(date27);
        Date date28 = jDateSearchFrom32.getDate();
        String police_training_period_to2 = dcn.format(date28);
        String military_training = jTextField87.getText();
        String military_training_module = jTextField88.getText();
        String military_training_provided_by = jTextField89.getText();
        String military_training_location = jTextField90.getText();
        String military_training_qualified = jTextField95.getText();
        Date date29 = jDateSearchFrom33.getDate();
        String military_training_period_from = dcn.format(date29);
        Date date30 = jDateSearchFrom34.getDate();
        String military_training_period_to = dcn.format(date30);
        String military_training2 = jTextField91.getText();
        String military_training_module2 = jTextField92.getText();
        String military_training_provided_by2 = jTextField93.getText();
        String military_training_location2 = jTextField94.getText();
        String military_training_qualified2 = jTextField96.getText();
        Date date31 = jDateSearchFrom35.getDate();
        String military_training_period_from2 = dcn.format(date31);
        Date date32 = jDateSearchFrom36.getDate();
        String military_training_period_to2 = dcn.format(date32);
        String qualification1 = jTextField97.getText();
        String qualification2 = jTextField98.getText();
        String qualification3 = jTextField99.getText();
        String arabic_speak = null;
        if (jCheckBox9.isSelected() == true) {
            arabic_speak = "Can Speak";
        } else {
            arabic_speak = "Can't Speak";
        }
        String arabic_read = null;
        if (jCheckBox13.isSelected() == true) {
            arabic_read = "Can Read";
        } else {
            arabic_read = "Can't Read";
        }
        String arabic_write = null;
        if (jCheckBox17.isSelected() == true) {
            arabic_write = "Can Write";
        } else {
            arabic_write = "Can't Speak";
        }
        String arabic = arabic_speak + "&" + arabic_read + "&" + arabic_write;
        String english_speak = null;
        if (jCheckBox9.isSelected() == true) {
            english_speak = "Can Speak";
        } else {
            english_speak = "Can't Speak";
        }
        String english_read = null;
        if (jCheckBox13.isSelected() == true) {
            english_read = "Can Read";
        } else {
            english_read = "Can't Read";
        }
        String english_write = null;
        if (jCheckBox17.isSelected() == true) {
            english_write = "Can Write";
        } else {
            english_write = "Can't Speak";
        }
        String english = english_speak + "&" + english_read + "&" + english_write;
        String other_language_text = jTextField104.getText();
        String other_language_speak = null;
        if (jCheckBox9.isSelected() == true) {
            other_language_speak = "Can Speak";
        } else {
            other_language_speak = "Can't Speak";
        }
        String other_language_read = null;
        if (jCheckBox13.isSelected() == true) {
            other_language_read = "Can Read";
        } else {
            other_language_read = "Can't Read";
        }
        String other_language_write = null;
        if (jCheckBox17.isSelected() == true) {
            other_language_write = "Can Write";
        } else {
            other_language_write = "Can't Speak";
        }
        String other_language = other_language_text + "&" + other_language_speak + "&" + other_language_read + "&" + other_language_write;
        String language_text = jTextField105.getText();
        String language_speak = null;
        if (jCheckBox10.isSelected() == true) {
            language_speak = "Can Speak";
        } else {
            language_speak = "Can't Speak";
        }
        String language_read = null;
        if (jCheckBox14.isSelected() == true) {
            language_read = "Can Read";
        } else {
            language_read = "Can't Read";
        }
        String language_write = null;
        if (jCheckBox18.isSelected() == true) {
            language_write = "Can Write";
        } else {
            language_write = "Can't Speak";
        }
        String language2 = language_text + "&" + language_speak + "&" + language_read + "&" + language_write;
        String calibre = jTextField102.getText();
        String weapon_type = jTextField103.getText();
        String serial_number = jTextField106.getText();
        String ammunition_number = jTextField107.getText();
        String provided_by = jTextField108.getText();
        String location = jTextField109.getText();
        Date date33 = jDateSearchFrom37.getDate();
        String receipt_date = dcn.format(date33);
        String calibre1 = jTextField110.getText();
        String weapon1_type = jTextField111.getText();
        String serial_number1 = jTextField112.getText();
        String ammunition1 = jTextField113.getText();
        String provided_by1 = jTextField114.getText();
        String location1 = jTextField115.getText();
        Date date34 = jDateSearchFrom38.getDate();
        String receipt_date1 = dcn.format(date34);
        String calibre2 = jTextField116.getText();
        String weapon2_type = jTextField117.getText();
        String serial_number2 = jTextField118.getText();
        String ammunition2 = jTextField119.getText();
        String provided_by2 = jTextField120.getText();
        String location2 = jTextField121.getText();
        Date date35 = jDateSearchFrom39.getDate();
        String receipt_date2 = dcn.format(date35);

        if (gender.isEmpty() || position.isEmpty() || email.isEmpty() || state.isEmpty() || county.isEmpty() || rank.isEmpty() || station.isEmpty() || height.isEmpty() || weight.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All Fields Are Mandatory!!");
        } else {
            try {
                conn = DBConnect.ConnecrDb();
                String sql = "Select p_id from updated_police_details WHERE p_id='" + p_id + "'";
                String sql2 = "Select p_id from updated_police_details2 WHERE p_id='" + p_id + "'";
                String sql3 = "Select p_id from updated_police_details3 WHERE p_id='" + p_id + "'";

                pst = conn.prepareStatement(sql);
                pst1 = conn.prepareStatement(sql2);
                pst2 = conn.prepareStatement(sql3);
                rs = pst.executeQuery();
                rs1 = pst1.executeQuery();
                rs2 = pst2.executeQuery();
                stmt = conn.createStatement();
                stmt1 = conn.createStatement();
                stmt2 = conn.createStatement();

                if (rs.next()) {
                    //do nothing

                } else {
                    //insert applicant id
                    String sql4 = "INSERT INTO updated_police_details (p_id) VALUES ('" + p_id + "')";
                    stmt.executeUpdate(sql4);
                    String sql5 = "INSERT INTO updated_police_details2 (p_id) VALUES ('" + p_id + "')";
                    stmt1.executeUpdate(sql5);
                    String sql6 = "INSERT INTO updated_police_details3 (p_id) VALUES ('" + p_id + "')";
                    stmt2.executeUpdate(sql6);
                }

                String query = "UPDATE updated_police_details SET"
                        + "gender =?,"
                        + "position_held=?,"
                        + "email=?,"
                        + "height=?,"
                        + "weight=?,"
                        + "state =?,"
                        + "county =?,"
                        + "rank=?,"
                        + "duty_station=?,"
                        + "retired=?,"
                        + "marital_status=?,"
                        + "present_address=?,"
                        + "nextkin_name=?,"
                        + "nextkin_address=?,"
                        + "nextkin_job=?,"
                        + "nextkin_phone=?,"
                        + "spouse_name=?,"
                        + "spouse_address=?,"
                        + "spouse_job=?,"
                        + "spouse2_name=?,"
                        + "spouse2_address=?,"
                        + "spouse2_job=?,"
                        + "child_name=?,"
                        + "child_date_birth=?,"
                        + "child2_name=?,"
                        + "child2_date_birth=?,"
                        + "child3_name=?,"
                        + "child3_date_birth=?,"
                        + "primary_institution=?,"
                        + "primary_location=?,"
                        + "primary_from=?,"
                        + "primary_to=?,"
                        + "primary_certificate=?,"
                        + "secondary_institution=?,"
                        + "secondary_location=?,"
                        + "secondary_from=?,"
                        + "secondary_to=?,"
                        + "secondary_certificate=?,"
                        + "college_institution=?,"
                        + "college_location=?,"
                        + "college_from=?,"
                        + "college_to=?,"
                        + "college_certificate=?,"
                        + "university_institution=?"
                        + "university_location=?,"
                        + "university_from=?,"
                        + "university_to=?,"
                        + "university_certificate=?,"
                        + "post_graduate=?,"
                        + "post_graduate_location=?,"
                        + "post_graduate_from=?,"
                        + "post_graduate_to=?,"
                        + "post_graduate_certificate=?,"
                        + "other=?,"
                        + "other_location=?,"
                        + "other_from=?,"
                        + "other_to=?,"
                        + "other_certificate=?, "
                        + "WHERE p_id=?";

                preparedStmt = conn.prepareStatement(query);

                preparedStmt.setString(1, gender);
                preparedStmt.setString(2, position);
                preparedStmt.setString(3, email);
                preparedStmt.setString(4, height);
                preparedStmt.setString(5, weight);
                preparedStmt.setString(6, state);
                preparedStmt.setString(7, county);
                preparedStmt.setString(8, rank);
                preparedStmt.setString(9, station);
                preparedStmt.setString(10, retire);
                preparedStmt.setString(11, marital);
                preparedStmt.setString(12, present);
                preparedStmt.setString(13, nameKin);
                preparedStmt.setString(14, addressKin);
                preparedStmt.setString(15, jobKin);
                preparedStmt.setString(16, phoneKin);
                preparedStmt.setString(17, spouseName);
                preparedStmt.setString(18, spouseAddress);
                preparedStmt.setString(19, spouseJob);
                preparedStmt.setString(20, anotherSpouse);
                preparedStmt.setString(21, anotherAddress);
                preparedStmt.setString(22, anotherJob);
                preparedStmt.setString(23, childName);
                preparedStmt.setString(24, childdate);
                preparedStmt.setString(25, anotherChild);
                preparedStmt.setString(26, datebirth);
                preparedStmt.setString(27, child3);
                preparedStmt.setString(28, birth3);
                preparedStmt.setString(29, primary_institution);
                preparedStmt.setString(30, primary_location);
                preparedStmt.setString(31, primary_from);
                preparedStmt.setString(32, primary_to);
                preparedStmt.setString(33, primary_certificate);
                preparedStmt.setString(34, secondary_institution);
                preparedStmt.setString(35, secondary_location);
                preparedStmt.setString(36, secondary_from);
                preparedStmt.setString(37, secondary_to);
                preparedStmt.setString(38, secondary_certificate);
                preparedStmt.setString(39, college_institution);
                preparedStmt.setString(40, college_location);
                preparedStmt.setString(41, college_from);
                preparedStmt.setString(42, college_to);
                preparedStmt.setString(43, college_certificate);
                preparedStmt.setString(44, university_institution);
                preparedStmt.setString(45, university_location);
                preparedStmt.setString(46, university_from);
                preparedStmt.setString(47, university_to);
                preparedStmt.setString(48, university_certificate);
                preparedStmt.setString(49, post_graduate);
                preparedStmt.setString(50, post_graduate_location);
                preparedStmt.setString(51, post_graduate_from);
                preparedStmt.setString(52, post_graduate_to);
                preparedStmt.setString(53, post_graduate_certificate);
                preparedStmt.setString(54, other_institution);
                preparedStmt.setString(55, other_location);
                preparedStmt.setString(56, other_from);
                preparedStmt.setString(57, other_to);
                preparedStmt.setString(58, other_certificate);
                String id = Integer.toString(p_id);
                preparedStmt.setString(59, id);

                preparedStmt.executeUpdate();

                String query2 = "UPDATE updated_police_details2 SET"
                        + "police_work=?,"
                        + "police_work_location=?,"
                        + "police_work_rank=?,"
                        + "police_work_from=?,"
                        + "police_work_to=?,"
                        + "police_work2=?,"
                        + "police_work_location2=?,"
                        + "police_work_rank2=?,"
                        + "police_work_from2=?,"
                        + "police_work_to2=?,"
                        + "civil_work=?,"
                        + "civil_description=?,"
                        + "civil_work_location=?,"
                        + "civil_duration_from=?,"
                        + "civil_duration_to=?,"
                        + "civil_work2=?,"
                        + "civil_description2=?,"
                        + "civil_provided_by=?,"
                        + "civil_provided_by2=?,"
                        + "civil_work_location2=?,"
                        + "civil_duration_from2=?,"
                        + "civil_duration_to2=?,"
                        + "military_work=?,"
                        + "military_description=?,"
                        + "military_work_location=?,"
                        + "military_duration_from=?,"
                        + "military_duration_to=?,"
                        + "military_work2=?,"
                        + "military_description2=?,"
                        + "military_provided_by=?,"
                        + "military_provided_by2=?,"
                        + "military_work_location2=?,"
                        + "military_duration_from2=?,"
                        + "military_duration_to2=?"
                        + "WHERE p_id=?";
                preparedStmt2 = conn.prepareStatement(query2);

                preparedStmt2.setString(1, police_work);
                preparedStmt2.setString(2, police_work_location);
                preparedStmt2.setString(3, police_work_rank);
                preparedStmt2.setString(4, police_work_from);
                preparedStmt2.setString(5, police_work_to);
                preparedStmt2.setString(6, police_work2);
                preparedStmt2.setString(7, police_work_location2);
                preparedStmt2.setString(8, police_work_rank2);
                preparedStmt2.setString(9, police_work_from2);
                preparedStmt2.setString(10, police_work_to2);
                preparedStmt2.setString(11, civil_work);
                preparedStmt2.setString(12, civil_description);
                preparedStmt2.setString(13, civil_work_location);
                preparedStmt2.setString(14, civil_duration_from);
                preparedStmt2.setString(15, civil_duration_to);
                preparedStmt2.setString(16, civil_work2);
                preparedStmt2.setString(17, civil_description2);
                preparedStmt2.setString(18, civil_provided_by);
                preparedStmt2.setString(19, civil_provided_by2);
                preparedStmt2.setString(20, civil_work_location2);
                preparedStmt2.setString(21, civil_duration_from2);
                preparedStmt2.setString(22, civil_duration_to2);
                preparedStmt2.setString(23, military_work);
                preparedStmt2.setString(24, military_description);
                preparedStmt2.setString(25, military_work_location);
                preparedStmt2.setString(26, military_duration_from);
                preparedStmt2.setString(27, military_duration_to);
                preparedStmt2.setString(28, military_work2);
                preparedStmt2.setString(29, military_description2);
                preparedStmt2.setString(30, military_provided_by);
                preparedStmt2.setString(31, military_provided_by2);
                preparedStmt2.setString(32, military_work_location2);
                preparedStmt2.setString(33, military_duration_from2);
                preparedStmt2.setString(34, military_duration_to2);
                String id1 = Integer.toString(p_id);
                preparedStmt2.setString(35, id1);

                preparedStmt2.executeUpdate();

                String query3 = "UPDATE updated_police_details3 SET"
                        + "qualification1=?,"
                        + "qualification2=?,"
                        + "qualification3=?,"
                        + "police_training=?,"
                        + "police_training_module=?,"
                        + "police_training_provided_by=?,"
                        + "police_training_location=?,"
                        + "police_training_qualified=?,"
                        + "police_training_period_from=?,"
                        + "police_training_period_to=?,"
                        + "police_training2=?,"
                        + "police_training_module2=?,"
                        + "police_training_provided_by2=?,"
                        + "police_training_location2=?,"
                        + "police_training_qualified2=?,"
                        + "police_training_period_from2=?,"
                        + "police_training_period_to2=?,"
                        + "military_training=?,"
                        + "military_training_module=?,"
                        + "military_training_provided_by=?,"
                        + "military_training_location=?,"
                        + "military_training_qualified=?,"
                        + "military_training_period_from=?,"
                        + "military_training_period_to=?,"
                        + "military_training2=?,"
                        + "military_training_module2=?,"
                        + "military_training_provided_by2=?,"
                        + "military_training_location2=?,"
                        + "military_training_qualified2=?,"
                        + "military_training_period_from2=?,"
                        + "military_training_period_to2=?,"
                        + "calibre=?,"
                        + " weapon_type=?,"
                        + " serial_number=?,"
                        + " ammunition_number=?,"
                        + " provided_by=?,"
                        + " location=?,"
                        + " receipt_date=?,"
                        + " calibre1=?,"
                        + " weapon1_type=?,"
                        + " serial_number1=?,"
                        + " ammunition1=?,"
                        + " provided_by1=?,"
                        + " location1=?,"
                        + " receipt_date1=?,"
                        + " calibre2=?,"
                        + " weapon2_type=?,"
                        + " serial_number2=?,"
                        + " ammunition2=?,"
                        + " provided_by2=?,"
                        + " location2=?,"
                        + " receipt_date2=?"
                        + "WHERE p_id=?";

                preparedStmt3 = conn.prepareStatement(query3);

                preparedStmt3.setString(1, qualification1);
                preparedStmt3.setString(2, qualification2);
                preparedStmt3.setString(3, qualification3);
                preparedStmt3.setString(4, police_training);
                preparedStmt3.setString(5, police_training_module);
                preparedStmt3.setString(6, police_training_provided_by);
                preparedStmt3.setString(7, police_training_location);
                preparedStmt3.setString(8, police_training_qualified);
                preparedStmt3.setString(9, police_training_period_from);
                preparedStmt3.setString(10, police_training_period_to);
                preparedStmt3.setString(11, police_training2);
                preparedStmt3.setString(12, police_training_module2);
                preparedStmt3.setString(13, police_training_provided_by2);
                preparedStmt3.setString(14, police_training_location2);
                preparedStmt3.setString(15, police_training_qualified2);
                preparedStmt3.setString(16, police_training_period_from2);
                preparedStmt3.setString(17, police_training_period_to2);
                preparedStmt3.setString(18, military_training);
                preparedStmt3.setString(19, military_training_module);
                preparedStmt3.setString(20, military_training_provided_by);
                preparedStmt3.setString(21, military_training_location);
                preparedStmt3.setString(22, military_training_qualified);
                preparedStmt3.setString(23, military_training_period_from);
                preparedStmt3.setString(24, military_training_period_to);
                preparedStmt3.setString(25, military_training2);
                preparedStmt3.setString(26, military_training_module2);
                preparedStmt3.setString(27, military_training_provided_by2);
                preparedStmt3.setString(28, military_training_location2);
                preparedStmt3.setString(29, military_training_qualified2);
                preparedStmt3.setString(30, military_training_period_from2);
                preparedStmt3.setString(31, military_training_period_to2);
                preparedStmt3.setString(32, calibre);
                preparedStmt3.setString(33, weapon_type);
                preparedStmt3.setString(34, serial_number);
                preparedStmt3.setString(35, ammunition_number);
                preparedStmt3.setString(36, provided_by);
                preparedStmt3.setString(37, location);
                preparedStmt3.setString(38, receipt_date);
                preparedStmt3.setString(39, calibre1);
                preparedStmt3.setString(40, weapon1_type);
                preparedStmt3.setString(41, serial_number1);
                preparedStmt3.setString(42, ammunition1);
                preparedStmt3.setString(43, provided_by1);
                preparedStmt3.setString(44, location1);
                preparedStmt3.setString(45, receipt_date1);
                preparedStmt3.setString(46, calibre2);
                preparedStmt3.setString(47, weapon2_type);
                preparedStmt3.setString(48, serial_number2);
                preparedStmt3.setString(49, ammunition2);
                preparedStmt3.setString(50, provided_by2);
                preparedStmt3.setString(51, location2);
                preparedStmt3.setString(52, receipt_date2);
                String id2 = Integer.toString(p_id);
                preparedStmt3.setString(53, id2);

                preparedStmt3.executeUpdate();

                String query4 = "UPDATE police_details SET update_status ='" + 1 + "'WHERE id = '" + p_id + "'";
                st = conn.createStatement();
                st.executeUpdate(query4);

                JOptionPane.showMessageDialog(null, "Details Sent For Approval!");

                data.setForm(new FragmentInformationUpdate(data));

            } catch (SQLException e) {
                System.err.println();
                e.printStackTrace();
            } finally {
                if (preparedStmt != null) {

                    preparedStmt.close();

                }
                if (preparedStmt2 != null) {

                    preparedStmt2.close();

                }
                if (preparedStmt3 != null) {

                    preparedStmt3.close();

                }
                if (pst != null) {

                    pst.close();

                }
                if (pst1 != null) {

                    pst1.close();

                }
                if (pst2 != null) {

                    pst2.close();

                }
                if (rs != null) {

                    rs.close();

                }
                if (rs1 != null) {

                    rs1.close();

                }
                if (rs2 != null) {

                    rs2.close();

                }

                if (conn != null) {

                    conn.close();

                }

            }
        }

    }

}
