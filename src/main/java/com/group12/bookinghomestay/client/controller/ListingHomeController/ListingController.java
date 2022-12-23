package com.group12.bookinghomestay.client.controller.ListingHomeController;

import com.group12.bookinghomestay.admin.model.*;
import com.group12.bookinghomestay.client.dto.PropertyDto;
import com.group12.bookinghomestay.client.model.ResponseObject;
import com.group12.bookinghomestay.client.service.*;
import com.group12.bookinghomestay.client.service.EmaiService.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/List")
@CrossOrigin
public class ListingController {
    @Autowired
    private HotelClientService hotelService;
    @Autowired
    private RoomClientService roomService;
    @Autowired
    private OwnerClientService ownerService;
    @Autowired
    private PlaceClientService placeService;
    @Autowired
    private RoomTypeClientService roomTypeClientService;
    @Autowired
    private UserClientService userService;
    @Autowired
    private EmailSenderService mailService;
    @PostMapping("/save")
    ResponseEntity<ResponseObject> saveProperty(@RequestBody PropertyDto property){
        //init value
        int hotelStatus =0;
        Date date = new Date();
        Timestamp dateData = new Timestamp(date.getTime());
        //save place
        //place value
        Place place = new Place(property.getAddress()
                ,property.getDistrict(), property.getProvince(), property.getCountry());
        //save place
        placeService.savePlace(place);
        //set hotel value
        Hotel hotel = new Hotel(property.getNameProperty()
                          , property.getOwner_id(), Math.toIntExact(place.getId()), property.getInfoProperty(), property.getPolicy(),dateData,hotelStatus);
        //save hotel
        hotelService.saveHotel(hotel);
        //get room
        int roomStatus=0;
        double discount =0.0;
        RoomType rtype = new RoomType(property.getPropertyType(),property.getInfoProperty());
        roomTypeClientService.saveRoomType(rtype);
        Room room = new Room(hotel,property.getNumberAdult(), property.getNumberChildren(),roomStatus,property.getPrice(),discount,rtype);
        //roomService.saveRoom(room);
        //save image
        //send mail
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert user success",roomService.saveRoom(room))
        );
    }

    @GetMapping("/getOwner/{username}")
    public int getOwnerIdByUserName(@PathVariable String username){
        Owner owner = ownerService.getOwnerByUserName(username);
        return (int) owner.getId();
    }
    @GetMapping("/getRoom/{status}")
    public List<Room> getRoomByState(@PathVariable int status){
        List<Room> room = roomService.getRoomByState(status);
        return room;
    }
    @GetMapping("/getHotel/{status}")
    public List<Hotel> getHotelByStatus(String status){
        return null;
    }
    @PutMapping("publishRoom/{id}")
    public ResponseEntity<ResponseObject> publishRoom(@PathVariable long id){
        Room room = roomService.getRoomById(id);
        room.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Active Home Success",roomService.saveRoom(room))
        );
    }
    @PutMapping("activeRoom/{id}")
    public ResponseEntity<ResponseObject> activeByRoomId(@PathVariable long id){
        Room room = roomService.getRoomById(id);
        room.setStatus(2);
        room.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Active Home Success",roomService.saveRoom(room))
        );
    }
    @PutMapping("deActiveRoom/{id}")
    public ResponseEntity<ResponseObject> deActiveByRoomId(@PathVariable long id){
        Room room = roomService.getRoomById(id);
        room.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Active Home Success",roomService.saveRoom(room))
        );
    }
}
