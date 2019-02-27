package by.dsp.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.dsp.model.Color;
import by.dsp.model.Detail;
import by.dsp.model.Edging;
import by.dsp.model.Fibreboard;
import by.dsp.model.Groove;
import by.dsp.model.Material;
import by.dsp.model.ProxiDspObject;
import by.dsp.model.QuarterSpace;

public class JSONUtils {
	
	public static void parseJSONLineToJSONObjectSList(String json, List<JSONObject>list) throws ParseException{
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray)parser.parse(json);
		Iterator it = array.iterator();
		while(it.hasNext()){
			list.add((JSONObject)it.next());
		}
	}
	
	public static JSONObject parseRequestBodyToJSONObject(String body){
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {
			JSONUtils.parseJSONLineToJSONObjectSList(body,list);
		} catch (ParseException e) {
			return null;
		}
		if(list.size()!=1)return null;
		return list.get(0);
	}
	
	
	
	
	public static List<JSONObject> getJSONarray(String line){
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(line);
			JSONArray array = (JSONArray)object;
			Iterator it = array.iterator();
			List<JSONObject>list = new ArrayList<>();
			while(it.hasNext())list.add((JSONObject)it.next());
			
			return list;
		} catch (ParseException e) {
			e.printStackTrace();
			return new ArrayList<JSONObject>();
		}
	}
	
	public static Color getColorFromJSON(JSONObject json) throws ParseException{
		if(json==null) return null;
		String name = json.get("name").toString();
		boolean structure = Boolean.parseBoolean(json.get("structure").toString());
		return new Color(name,structure);
	}
	
	public static Material getMaterialFromJSON(JSONObject json) throws ParseException{
		if(json==null)return null;
		if(json.get("type")==null){
			Color color = getColorFromJSON((JSONObject)json.get("Color"));
			int thickness = Integer.parseInt(json.get("thickness").toString());
			return new Material(color,thickness);
		}else{
			if(((String)json.get("type")).equals("fibreboard"))return new Fibreboard();
		}
		return null;
	}
	
	
	public static Edging getEdgingFromJSON(JSONObject json) throws ParseException{
		if(json==null)return null;
		String color = json.get("Color").toString();
		double thickness = Double.parseDouble(json.get("thickness").toString());
		int width = Integer.parseInt(json.get("width").toString());
		return new Edging(color,thickness,width);
	}
	
	public static QuarterSpace getQuarterSpaceFromJSON(JSONObject json) throws ParseException{
		if(json==null)return null;
		double depth = Double.parseDouble(json.get("depth").toString());
		double spacing = Double.parseDouble(json.get("spacing").toString());
		boolean faceSide = Boolean.parseBoolean(json.get("faceSide").toString());
		return new QuarterSpace(depth,spacing,faceSide);
	}
	
	public static Groove getGrooveFromJSON(JSONObject json) throws ParseException{
		if(json==null)return null;
		double thickness = Double.parseDouble(json.get("thickness").toString());
		double depth = Double.parseDouble(json.get("depth").toString());
		double spacing = Double.parseDouble(json.get("spacing").toString());
		boolean faceSide = Boolean.parseBoolean(json.get("faceSide").toString());
		return new Groove(spacing,thickness,depth,faceSide);
	}
	
	public static Detail getDetailFromJSON(JSONObject json) throws ParseException{
		int height = Integer.parseInt(json.get("height").toString());
		int width = Integer.parseInt(json.get("width").toString());
		int amount = Integer.parseInt(json.get("amount").toString());
		Long schemeId = null;
		Object tempScheme = json.get("image");
		if(tempScheme!=null)schemeId = Long.parseLong(tempScheme.toString());
		Material material = getMaterialFromJSON((JSONObject)json.get("Material"));
		Edging y1e = null;
		if(json.get("y1edging")!=null){
			String temp = json.get("y1edging").toString();
			y1e=new Edging(temp);
		}
		Edging y2e = null;
		if(json.get("y2edging")!=null){
			String temp = json.get("y2edging").toString();
			y2e=new Edging(temp);
		}
		Edging x1e = null;
		if(json.get("x1edging")!=null){
			String temp = json.get("x1edging").toString();
			x1e=new Edging(temp);
		}
		Edging x2e = null;
		if(json.get("x2edging")!=null){
			String temp = json.get("x2edging").toString();
			x2e=new Edging(temp);
		}
		Groove y1g = getGrooveFromJSON((JSONObject)json.get("y1groove"));
		Groove y2g = getGrooveFromJSON((JSONObject)json.get("y2groove"));
		Groove x1g = getGrooveFromJSON((JSONObject)json.get("x1groove"));
		Groove x2g = getGrooveFromJSON((JSONObject)json.get("x2groove"));
		QuarterSpace y1qs = getQuarterSpaceFromJSON((JSONObject)json.get("y1quarter"));
		QuarterSpace y2qs = getQuarterSpaceFromJSON((JSONObject)json.get("y2quarter"));
		QuarterSpace x1qs = getQuarterSpaceFromJSON((JSONObject)json.get("x1quarter"));
		QuarterSpace x2qs = getQuarterSpaceFromJSON((JSONObject)json.get("x2quarter"));
		boolean milling = Boolean.parseBoolean(json.get("milling").toString());
		Object remark0 = json.get("remark");
		String remark;
		if(remark0!=null){
			remark =remark0.toString();
		}else remark = "";
		boolean isDoubleLayer = Boolean.parseBoolean(json.get("isDoubleLayered").toString());
		boolean isOrientationFixed = Boolean.parseBoolean(json.get("isOrientationFixed").toString());
		Detail detail = Detail.Builder.buildDetail()
				.setSize(height, width)
				.setAmount(amount)
				.setMaterial(material)
				.setEdging(y1e,y2e,x1e,x2e)
				.setGroove(y1g, y2g, x1g, x2g)
				.setQuarterSpace(y1qs, y2qs, x1qs, x2qs)
				.setDoubleLayer(isDoubleLayer)
				.setFixedOrientation(isOrientationFixed)
				.setRemark(remark)
				.milling(milling)
				.setDetailScheme(schemeId)
				.getDetail();
		return detail;
	}
	
	public static List<Detail> getDetailListFromJson(String line){
		List<Detail>list = new ArrayList<Detail>();
		List<JSONObject>jsons = getJSONarray(line);
		for(JSONObject json:jsons){
			try {
				Detail detail = getDetailFromJSON(json);
				list.add(detail);
			} catch (ParseException e) {
				System.out.println("can't read: ");
				System.out.println(json.toJSONString());
			}
		}
		return list;
	}
	
	public static List<Color> getColorListFromJSON(String line){
		List<Color>colors = new ArrayList<Color>();
		List<JSONObject>jsons = getJSONarray(line);
		for(JSONObject json:jsons){
			Object name = json.get("name");
			Object structure = json.get("structure");
			if(name!=null&&structure!=null){
				colors.add(new Color(name.toString(),Boolean.parseBoolean(structure.toString())));
			}
		}
		return colors;
	}
	
	public static List<Edging> getEdgingListFromJSON(String line){
		List<Edging>edgings = new ArrayList<Edging>();
		List<JSONObject>jsons = getJSONarray(line);
		for(JSONObject json:jsons){
			Object color = json.get("Color");
			Object thickness = json.get("thickness");
			Object width = json.get("width");
			if(color!=null&&thickness!=null&&width!=null){
				try{
					int w = Integer.parseInt(width.toString());
					double t = Double.parseDouble(thickness.toString());
					Edging ed = new Edging(color.toString(),t,w);
					edgings.add(ed);
				}catch(Exception e){
					continue;
				}
			}
		}
		return edgings;
}
	
	public static String proxiObjectListToJson(List<ProxiDspObject>list){
		JSONArray array = new JSONArray();
		for(ProxiDspObject proxi:list){
			JSONObject ob = new JSONObject();
			if(proxi.isColorIsSaved())ob.put("colorId", proxi.getColorId());
			if(proxi.colorNameNotNull())ob.put("colorName", proxi.getColorName());
			ob.put("colorStructure", proxi.isColorStructure());
			ob.put("colorShow", proxi.isColorShow());
			if(proxi.colorHasPicture())ob.put("colorPicture", proxi.getColorPicture());
			if(proxi.itemNotNull())ob.put("item", proxi.getItem());
			if(proxi.articleNameNotNull())ob.put("articleName", proxi.getArticleName());
			ob.put("materialThickness", proxi.getMaterialThickness());
			array.add(ob);
		}
		return array.toJSONString();
	}

	public static List<ProxiDspObject> proxiDspObjectListFromJson(String json){
		List<ProxiDspObject>list = new ArrayList<>();
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray)parser.parse(json);
			for(Object jsonOb:array){
				JSONObject ob = (JSONObject)jsonOb;
				try{
					ProxiDspObject proxi = ProxiDspObject.Builder.build()
							.setColorId(ob.get("colorId")!=null?(Long)ob.get("colorId"):0)
						.setColorName((String)ob.get("colorName"))
						.setColorStructure((Boolean)ob.get("colorStructure"))
						.setColorShow((Boolean)ob.get("colorShow"))
						.setItem((String)ob.get("item"))
						.setArticleName((String)ob.get("articleName"))
						.setMaterialThickness(((Long)ob.get("materialThickness")).intValue())
						.getObgect();
					list.add(proxi);
				}catch(RuntimeException e){
					e.printStackTrace();
					continue;
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}
}
