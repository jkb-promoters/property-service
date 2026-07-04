package com.jkb.property.config;

import com.jkb.property.model.Property;
import com.jkb.property.repository.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSeeder {

    private Property make(String title, String desc, String propType, String listingType,
                          BigDecimal price, BigDecimal pricePerSqft, int area,
                          Integer plotArea, Integer beds, Integer baths, Integer balc,
                          Integer floors, Integer floorNo, String locality, String address,
                          String pin, String status, String facing, String parking,
                          String furnishing, int age, String amenities, LocalDate posted,
                          boolean rera, String reraNo, String landmarks, String imageUrl,
                          Long promoterId) {
        Property p = new Property();
        p.setTitle(title); p.setDescription(desc); p.setPropertyType(propType);
        p.setListingType(listingType); p.setPriceInr(price); p.setPricePerSqft(pricePerSqft);
        p.setAreaSqft(area); p.setPlotAreaSqft(plotArea); p.setBedrooms(beds);
        p.setBathrooms(baths); p.setBalconies(balc); p.setFloors(floors);
        p.setFloorNumber(floorNo); p.setLocality(locality); p.setAddress(address);
        p.setPinCode(pin); p.setStatus(status); p.setFacing(facing); p.setParking(parking);
        p.setFurnishing(furnishing); p.setAge(age); p.setAmenities(amenities);
        p.setPostedDate(posted); p.setRera(rera); p.setReraNumber(reraNo);
        p.setNearbyLandmarks(landmarks); p.setImageUrl(imageUrl); p.setPromoterId(promoterId);
        return p;
    }

    @Bean
    public CommandLineRunner seedProperties(PropertyRepository repo) {
        return args -> {
            List<Property> props = new ArrayList<>();

            // Promoter IDs: 1=Arumugam, 2=Selvakumari, 3=Murugesan, 4=Lakshmipriya, 5=Thandapani

            props.add(make("Luxury 3 BHK in Prime T. Nagar Location",
                "A spacious and well-ventilated 3 BHK apartment in the heart of T. Nagar, walking distance to Pondy Bazaar. On the 8th floor of a 12-storey RERA-registered building with marble flooring, modular kitchen, and excellent metro connectivity.",
                "Apartment","For Sale",new BigDecimal("12500000"),new BigDecimal("9615"),1300,null,3,2,2,12,8,
                "T. Nagar","No. 24, Nagappa Street, T. Nagar, Chennai","600017","Available","East","Both","Semi-Furnished",0,
                "Swimming Pool,Gym,24/7 Security,Power Backup,Children's Play Area,Club House,CCTV,Rainwater Harvesting,Covered Parking,Intercom",
                LocalDate.of(2025,5,10),true,"TN/01/Building/0289/2024",
                "Pondy Bazaar,Panagal Park,Chennai Metro (T. Nagar),Valluvar Kottam",
                "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?w=800",1L));

            props.add(make("Elegant 2 BHK Apartment – Adyar Riverside",
                "Vastu-compliant 2 BHK with partial river view in prestigious Adyar. Boutique 8-floor building, teak wood doors, granite kitchen countertop, and premium fittings. Close to IIT Madras.",
                "Apartment","For Sale",new BigDecimal("9800000"),new BigDecimal("8909"),1100,null,2,2,1,8,5,
                "Adyar","No. 7, Kasturba Nagar 1st Street, Adyar, Chennai","600020","Available","North","4-Wheeler","Unfurnished",2,
                "CCTV,Intercom,Power Backup,Covered Parking,Lift,Maintenance Staff,Rainwater Harvesting",
                LocalDate.of(2025,6,1),true,"TN/01/Building/0312/2024",
                "IIT Madras Gate,Adyar Beach,Thiruvanmiyur Metro,Adyar Library",
                "https://images.unsplash.com/photo-1545324418-cc1a3fa10c00?w=800",1L));

            props.add(make("Premium Villa with Private Garden – Mylapore",
                "Exclusive independent villa near Kapaleeshwarar Temple. 4 BHK with private garden, servant quarters, Chettinad-inspired architecture, and modern comforts.",
                "Villa","For Sale",new BigDecimal("35000000"),new BigDecimal("8750"),4000,2800,4,4,3,2,1,
                "Mylapore","No. 12, Luz Church Road, Mylapore, Chennai","600004","Available","East","Both","Semi-Furnished",5,
                "Private Garden,Servant Quarters,Pooja Room,Terrace Garden,Solar Panels,Water Softener,Borewell,Security Cabin,CCTV,Car Porch",
                LocalDate.of(2025,3,15),true,"TN/01/Building/0197/2023",
                "Kapaleeshwarar Temple,San Thome Cathedral,Mylapore MRC,Luz Metro",
                "https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?w=800",1L));

            props.add(make("Cosy 1 BHK for Rent – Nungambakkam",
                "Well-maintained 1 BHK near consulates, MNC offices, and restaurants. Modular kitchen, basic furniture. Immediate occupation. No brokerage from tenant.",
                "Apartment","For Rent",new BigDecimal("22000"),new BigDecimal("37"),600,null,1,1,1,4,1,
                "Nungambakkam","No. 3A, Khader Nawaz Khan Road, Nungambakkam, Chennai","600006","Available","South","2-Wheeler","Furnished",3,
                "CCTV,Intercom,Power Backup,Lift,24/7 Water Supply",
                LocalDate.of(2025,7,1),false,"",
                "US Consulate,Spencer Plaza,Chetpet Lake,Chennai Central (2 km)",
                "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=800",1L));

            props.add(make("Office Space – Commercial Hub, Anna Salai",
                "Prime Grade-A commercial office on the 4th floor of a tower on Anna Salai. Suitable for IT, consultancies and financial firms. 18-feet ceiling, pantry, server room. Min lease: 3 years.",
                "Commercial","For Lease",new BigDecimal("280000"),new BigDecimal("80"),3500,null,0,4,0,15,4,
                "Anna Salai","No. 1, Anna Salai (Mount Road), Chennai","600002","Available","West","Both","Furnished",4,
                "24/7 Security,CCTV,Power Backup,High-Speed Internet Duct,Conference Room,Cafeteria,Firefighting Systems,AHU HVAC,DG Backup,Dedicated Parking",
                LocalDate.of(2025,4,20),true,"TN/01/Commercial/0088/2024",
                "LIC Building,Gemini Flyover,Express Avenue Mall,Thousand Lights Metro",
                "https://images.unsplash.com/photo-1497366216548-37526070297c?w=800",1L));

            props.add(make("Penthouse with Marina View – Foreshore Estate",
                "Ultra-premium penthouse with breathtaking Marina Beach views. 4 BHK, home theatre, chef's kitchen, private infinity plunge pool on rooftop terrace. By appointment only.",
                "Penthouse","For Sale",new BigDecimal("75000000"),new BigDecimal("18750"),4000,null,4,5,4,20,20,
                "Foreshore Estate","No. 1, Kamarajar Salai, Foreshore Estate, Chennai","600028","Available","East","Both","Furnished",1,
                "Infinity Pool,Home Theatre,Private Terrace,Concierge Service,Valet Parking,Smart Home Automation,Wine Cellar,Gym,Jacuzzi,24/7 Security,CCTV,EV Charging",
                LocalDate.of(2025,2,1),true,"TN/01/Building/0001/2024",
                "Marina Beach,Madras War Memorial,Chennai High Court,Ripon Building",
                "https://images.unsplash.com/photo-1600566753086-00f18fb6b3ea?w=800",1L));

            props.add(make("Modern 2 BHK – Sholinganallur, OMR",
                "Contemporary 2 BHK in gated community on OMR IT corridor. Laminated wooden flooring, modular kitchen, landscaped garden. Pet-friendly.",
                "Apartment","For Sale",new BigDecimal("7200000"),new BigDecimal("6545"),1100,null,2,2,1,10,6,
                "Sholinganallur","OMR IT Corridor, Sholinganallur, Chennai","600119","Available","West","Both","Semi-Furnished",0,
                "Swimming Pool,Gym,Children's Play Area,Landscaped Garden,Club House,CCTV,Power Backup,Covered Parking,Intercom,Waste Management",
                LocalDate.of(2025,6,15),true,"TN/02/Building/0512/2025",
                "Sholinganallur Junction,Siruseri IT Park,Perungudi Tech Park,Chennai Bypass",
                "https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=800",2L));

            props.add(make("3 BHK Apartment – Perungudi Tech Corridor",
                "Spacious 3 BHK near Tidel Park and RMZ Millenia. 9th floor with skyline views, premium lifestyle amenities, surrounded by IT parks and fine-dining.",
                "Apartment","For Sale",new BigDecimal("11500000"),new BigDecimal("8214"),1400,null,3,3,2,15,9,
                "Perungudi","OMR, Perungudi, Chennai","600096","Available","North-East","Both","Unfurnished",0,
                "Rooftop Terrace,Swimming Pool,Gym,Squash Court,Children's Play Area,Supermarket,Cafeteria,CCTV,EV Charging,Smart Home,Power Backup,Rainwater Harvesting",
                LocalDate.of(2025,5,25),true,"TN/02/Building/0480/2024",
                "Tidel Park,RMZ Millenia,Perungudi Depot Metro,Thoraipakkam Junction",
                "https://images.unsplash.com/photo-1567767292278-a4f21aa2d36e?w=800",2L));

            props.add(make("IT-Ready Office Space – Siruseri SIPCOT",
                "Plug-and-play office in SIPCOT IT Park. Pre-fitted workstations, conference rooms, high-speed fibre. Suitable for startups, product companies, MNC India offices.",
                "Commercial","For Lease",new BigDecimal("160000"),new BigDecimal("55"),2900,null,0,6,0,6,3,
                "Siruseri","SIPCOT IT Park, Siruseri, Chennai","603103","Available","South","Both","Furnished",6,
                "High-Speed Fibre,Conference Rooms,24/7 Security,Power Backup,DG Backup,Cafeteria,CCTV,Rainwater Harvesting,EV Charging,Visitor Parking",
                LocalDate.of(2025,7,1),false,"",
                "SIPCOT IT Park,Kelambakkam Junction,Sholinganallur (8 km),Tamil Nadu Expressway",
                "https://images.unsplash.com/photo-1486325212027-8081e485255e?w=800",2L));

            props.add(make("2 BHK for Rent – Thoraipakkam",
                "Well-maintained 2 BHK in quiet Thoraipakkam pocket. Walking distance to OMR bus stops. Semi-furnished with wardrobe, kitchen chimney, ceiling fans. Three months deposit.",
                "Apartment","For Rent",new BigDecimal("28000"),new BigDecimal("28"),1000,null,2,2,1,6,3,
                "Thoraipakkam","Thoraipakkam, OMR, Chennai","600097","Available","East","2-Wheeler","Semi-Furnished",4,
                "CCTV,Intercom,Power Backup,Lift,24/7 Water Supply,Covered Parking",
                LocalDate.of(2025,6,28),false,"",
                "Thoraipakkam Signal,RMZ Centennial,CTS Campus,Perungudi Junction",
                "https://images.unsplash.com/photo-1554995207-c18c203602cb?w=800",2L));

            props.add(make("Spacious Independent House – Anna Nagar West",
                "G+2 independent house on 2400 sqft plot in Anna Nagar West. 5 BHK, prayer room, large kitchen, garden. First floor rented for additional income. Clear title documents.",
                "Independent House","For Sale",new BigDecimal("45000000"),new BigDecimal("10714"),4200,2400,5,5,3,3,1,
                "Anna Nagar","3rd Avenue, Anna Nagar West, Chennai","600040","Available","North","Both","Semi-Furnished",12,
                "Garden,Separate Rental Unit,Servant Quarters,Solar Water Heater,Borewell,Rainwater Harvesting,CCTV,Security Cabin,Large Kitchen,Prayer Room",
                LocalDate.of(2025,4,5),false,"",
                "Anna Nagar Tower Park,Koyambedu Bus Terminus,Arumbakkam Metro,Shanthi Colony",
                "https://images.unsplash.com/photo-1568605114967-8130f3a36994?w=800",3L));

            props.add(make("Row House – Padi, North Chennai",
                "3 BHK row house in gated community of 12 units. Front garden, terrace, utility room. CCTV, generator backup, children's play area. Padi metro 600m away. Vaastu-compliant.",
                "Row House","For Sale",new BigDecimal("16500000"),new BigDecimal("8250"),2000,900,3,3,2,3,1,
                "Padi","Padi-Kilpauk Main Road, Padi, Chennai","600050","Available","East","Both","Unfurnished",0,
                "Front Garden,Terrace,Children's Play Area,CCTV,Power Backup,Visitor Parking,Security Cabin",
                LocalDate.of(2025,5,18),true,"TN/01/Building/0398/2025",
                "Padi Metro,Ambattur Estate,Kilpauk Garden,Cooum River Front",
                "https://images.unsplash.com/photo-1570129477492-45c003edd2be?w=800",3L));

            props.add(make("Residential Plot – Kilpauk (CMDA Approved)",
                "Prime CMDA-approved east-facing plot on 30-feet road in Kilpauk. Clear title, all patta documents ready, no encumbrances. Guideline value: Rs.18,000/sqft.",
                "Plot","For Sale",new BigDecimal("22500000"),new BigDecimal("15000"),1500,1500,0,0,0,0,0,
                "Kilpauk","Kilpauk, Chennai","600010","Available","East","None","Unfurnished",0,
                "CMDA Approved,Patta Ready,30-feet Road,Clear Title,Underground Drainage,Overhead Water Tank",
                LocalDate.of(2025,3,28),false,"",
                "Kilpauk Medical College,Chetpet Lake,Kilpauk Metro,Vepery Market",
                "https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=800",3L));

            props.add(make("3 BHK Premium Apartment – Arumbakkam",
                "Premium 3 BHK with Anna Nagar Tower Park views in 15-floor high-rise. Italian marble, smart home, automated curtains, modular kitchen with island. RERA registered with OC.",
                "Apartment","For Sale",new BigDecimal("13000000"),new BigDecimal("8667"),1500,null,3,3,2,15,11,
                "Arumbakkam","Arumbakkam, Chennai","600106","Available","West","Both","Furnished",0,
                "Smart Home,Swimming Pool,Gym,Yoga Deck,Club House,Squash Court,CCTV,Power Backup,EV Charging,24/7 Security,Concierge,Rainwater Harvesting",
                LocalDate.of(2025,6,10),true,"TN/01/Building/0415/2025",
                "CMBT,Arumbakkam Metro,Anna Nagar Tower Park,Koyambedu Wholesale Market",
                "https://images.unsplash.com/photo-1512917774080-9991f1c4c750?w=800",3L));

            props.add(make("Affordable 2 BHK – Velachery (Near MRTS)",
                "Value-priced 2 BHK 400m from Velachery MRTS and 1km from Velachery Metro. Great for first-time homebuyers. 24/7 security, covered parking, children's play area.",
                "Apartment","For Sale",new BigDecimal("5800000"),new BigDecimal("5800"),1000,null,2,2,1,7,4,
                "Velachery","100 Feet Road, Velachery, Chennai","600042","Available","South","2-Wheeler","Unfurnished",8,
                "CCTV,Children's Play Area,Power Backup,Covered Parking,Lift,24/7 Water,Security Guard",
                LocalDate.of(2025,6,5),false,"",
                "Velachery MRTS,VR Mall,Phoenix Market City,Vijaya Hospital",
                "https://images.unsplash.com/photo-1484154218962-a197022b5858?w=800",4L));

            props.add(make("2 BHK Apartment for Rent – Tambaram West",
                "Freshly painted 2 BHK near Tambaram Junction. Granite flooring, SS fittings. Deposit: 2 months. Preferred: Government/private-sector families. Maintenance: Rs.1500/month.",
                "Apartment","For Rent",new BigDecimal("15000"),new BigDecimal("15"),980,null,2,2,1,5,2,
                "Tambaram","Tambaram West, Chennai","600045","Available","East","2-Wheeler","Unfurnished",6,
                "Lift,24/7 Water,CCTV,Security Guard,Covered Parking",
                LocalDate.of(2025,6,22),false,"",
                "Tambaram Junction,Tambaram Railway Station,CM Medical College,GST Road",
                "https://images.unsplash.com/photo-1493809842364-78817add7ffb?w=800",4L));

            props.add(make("3 BHK Under-Construction Apartment – Chromepet",
                "RERA-registered 3 BHK project at Chromepet. Handover December 2026. Corner units, OBD walls, VRF AC provision, video door phone, Jaguar CP fittings. Construction-linked payment.",
                "Apartment","For Sale",new BigDecimal("8500000"),new BigDecimal("7083"),1200,null,3,3,2,12,7,
                "Chromepet","Old Pallavaram Main Road, Chromepet, Chennai","600044","Under Construction","North-East","Both","Unfurnished",0,
                "Swimming Pool,Gym,Club House,CCTV,Power Backup,EV Charging,Rainwater Harvesting,Covered Parking,Children's Play Area,Jogging Track",
                LocalDate.of(2025,5,1),true,"TN/05/Building/0192/2025",
                "Chromepet Railway Station,Chromepet to GST Road,Old Pallavaram Metro,Pammal",
                "https://images.unsplash.com/photo-1487958449943-2429e8be8625?w=800",4L));

            props.add(make("1 BHK Studio Apartment – Pallikaranai",
                "Compact 1 BHK studio for bachelors or working professionals. Fully furnished: modular kitchen, double bed with storage, wall-mounted TV. Generator for lifts and common areas.",
                "Apartment","For Rent",new BigDecimal("12000"),new BigDecimal("23"),520,null,1,1,0,4,2,
                "Pallikaranai","Pallikaranai, Chennai","600100","Available","West","2-Wheeler","Furnished",3,
                "Power Backup,CCTV,Lift,24/7 Water,Intercom",
                LocalDate.of(2025,6,30),false,"",
                "Pallikaranai Wetlands,Vijaya Hospitals,Medavakkam Junction,OMR Toll",
                "https://images.unsplash.com/photo-1518005020951-eccb494ad742?w=800",4L));

            props.add(make("Luxury Beach Villa – Injambakkam, ECR",
                "Stunning 5-bedroom beachfront villa with 80-feet private beach access. Infinity pool, home cinema, smart home, barbecue garden. Award-winning architecture. Ideal as primary or premium holiday home.",
                "Villa","For Sale",new BigDecimal("95000000"),new BigDecimal("17273"),5500,5000,5,6,4,2,1,
                "Injambakkam","East Coast Road, Injambakkam, Chennai","600115","Available","East","Both","Furnished",2,
                "Private Beach Access,Infinity Pool,Home Cinema,Gym,Smart Home,Barbecue Garden,Solar Panels,EV Charging,Concierge,24/7 Security,Wine Cellar,Generator,Water Treatment Plant",
                LocalDate.of(2025,1,10),true,"TN/03/Building/0002/2024",
                "ECR Beach,Injambakkam Beach,Sholinganallur (12 km),Chennai Airport (30 km)",
                "https://images.unsplash.com/photo-1613977257363-707ba9348227?w=800",5L));

            props.add(make("Premium Gated Villa Community – Neelankarai",
                "Prestigious gated community at Neelankarai ECR. 4 BHK villas with private courtyard, utility yard, dedicated parking. Clubhouse with pool, indoor badminton, and cafe. RERA registered.",
                "Villa","For Sale",new BigDecimal("28000000"),new BigDecimal("8000"),3500,2000,4,4,3,2,1,
                "Neelankarai","ECR - Neelankarai, Chennai","600115","Available","East","Both","Unfurnished",0,
                "Community Pool,Club House,Indoor Badminton,Cafe,CCTV,24/7 Security,Landscaped Courtyard,EV Charging,Solar Street Lights,Rainwater Harvesting,Waste Segregation",
                LocalDate.of(2025,3,1),true,"TN/03/Building/0055/2025",
                "Neelankarai Beach,ECR Main Road,Palavakkam,Kottivakkam",
                "https://images.unsplash.com/photo-1600607687939-ce8a6c25118c?w=800",5L));

            repo.saveAll(props);
            System.out.println("✅ Property Service: 20 properties seeded.");
        };
    }
}
