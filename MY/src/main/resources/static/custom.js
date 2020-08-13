var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: parseFloat(busLocations[0].LATITUDE), lng: parseFloat(busLocations[0].LONGITUDE) },
        zoom: 14,
        scrollwheel: false
    });
	
    for (i=0; i<busLocations.length; i++){
        const contentString =
            "<div>" +
            "<h3> Route #: "+ parseInt(busLocations[i].ROUTE) +"</h3>" +
            "</div>" +
            "<div>" +            
            "<h3> Bus #: "+ parseInt(busLocations[i].VEHICLE) +"</h3>" +
            "</div>";
        const infowindow = new google.maps.InfoWindow({
            content: contentString
          });
        var marker = new google.maps.Marker({
            position: { lat: parseFloat(busLocations[i].LATITUDE), lng: parseFloat(busLocations[i].LONGITUDE) },
            map: map,
            icon: 'http://maps.google.com/mapfiles/kml/shapes/bus.png'
        });
        marker.addListener("click", () => {
            infowindow.open(map, marker);
        });
    }
}