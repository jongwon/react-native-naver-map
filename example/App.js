import 'react-native-gesture-handler';
import React, {useEffect} from 'react';
import NaverMapView, {Marker, Align} from './map';
import {PermissionsAndroid, Platform, Text} from 'react-native';
import {NavigationContainer} from '@react-navigation/native';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {createStackNavigator} from '@react-navigation/stack';

const P0 = {latitude: 37.564362, longitude: 126.977011};
const P1 = {latitude: 37.565051, longitude: 126.978567};
const P2 = {latitude: 37.565383, longitude: 126.976292};
const P4 = {latitude: 37.564834, longitude: 126.977218};

const Tab = createBottomTabNavigator();
const Stack = createStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="home" component={HomeScreen} />
        <Stack.Screen name="stack" component={MapViewScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

const HomeScreen = () => (
  <Tab.Navigator>
    <Tab.Screen name={'map'} component={MapViewScreen} />
    <Tab.Screen name={'text'} component={TextScreen} />
  </Tab.Navigator>
);

const TextScreen = () => {
  return <Text>text</Text>;
};

const MapViewScreen = ({navigation}) => {
  useEffect(() => {
    requestLocationPermission();
  }, []);

  return (
    <>
      <NaverMapView
        style={{width: '100%', height: '100%'}}
        showsMyLocationButton={true}
        center={{...P0, zoom: 16}}
        // onTouch={e => console.warn('onTouch', JSON.stringify(e.nativeEvent))}
        // onCameraChange={e => console.warn('onCameraChange', JSON.stringify(e))}
        // onMapClick={e => console.warn('onMapClick', JSON.stringify(e))}
        onMarkerClick={e => console.warn('onMarkerClick', JSON.stringify(e))}>
        <Marker
          coordinate={P0}
          name="북창동 볼링장"
          lanes={3}
          franchisee="Y"
          companyId={5}
          parking={10}
          bookingTimeCount={2}
          onClick={() => console.warn('onClick! p0')}
          caption={{text: 'test caption', align: Align.Left}}
        />
        <Marker
          name="섰다 볼링장"
          lanes={4}
          bookingTimeCount={1}
          coordinate={P1}
          companyId={1}
          favorites="Y"
        />
        <Marker
          name="W 볼링장"
          lanes={5}
          bookingTimeCount={0}
          coordinate={P2}
          companyId={2}
          favorites="Y"
        />
        <Marker
          coordinate={P4}
          name="여리네 창동 아줌마 볼링장"
          companyId={3}
          lanes={6}
          bookingTimeCount={2}
          width={48}
          height={48}
          favorites="N"
        />
      </NaverMapView>
    </>
  );
};

async function requestLocationPermission() {
  if (Platform.OS !== 'android') return;
  try {
    const granted = await PermissionsAndroid.request(
      PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION,
      {
        title: 'Location Permission',
        message: 'show my location need Location permission',
        buttonNeutral: 'Ask Me Later',
        buttonNegative: 'Cancel',
        buttonPositive: 'OK',
      },
    );
    if (granted === PermissionsAndroid.RESULTS.GRANTED) {
      console.log('You can use the location');
    } else {
      console.log('Location permission denied');
    }
  } catch (err) {
    console.warn(err);
  }
}

export default App;
