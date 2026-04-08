package com.pawpal.pawpal_backend.service;

import com.pawpal.pawpal_backend.dto.AdviceRequest;
import com.pawpal.pawpal_backend.dto.AdviceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceService {

    public AdviceResponse generateAdvice(AdviceRequest req) {

        String label = req.getLabel();

        if ("wound".equalsIgnoreCase(label)) {
            return handleWound(req);
        }

        if ("rash".equalsIgnoreCase(label)) {
            return handleRash(req);
        }

        return handleNormalSkin(req);
    }

    private AdviceResponse handleWound(AdviceRequest req) {

        AdviceResponse res = new AdviceResponse();
        res.setLabel("wound");

        boolean urgent =
                req.isDeep() ||
                req.isBleeding() ||
                req.isBiteOrAnimalCause();

        boolean vetSoon =
                req.isPainOrLimping() ||
                req.isSwellingOrSmell();

        if (urgent) {
            res.setUrgency("urgent_now");
            res.setSummary("This may be a serious wound. A vet should examine it urgently.");
        }
        else if (vetSoon) {
            res.setUrgency("vet_soon");
            res.setSummary("This wound should be checked by a vet soon.");
        }
        else {
            res.setUrgency("home_care");
            res.setSummary("This may be a minor wound that can be monitored closely.");
        }

        res.setPossibleCauses(List.of(
                "minor injury",
                "scratch",
                "bite",
                "skin trauma"
        ));

        res.setSafeHomeCare(List.of(
                "Keep the area clean and dry",
                "Prevent licking or scratching",
                "Avoid using human medicines"
        ));

        res.setGoToVetIf(List.of(
                "bleeding continues",
                "the wound becomes swollen",
                "there is pus or discharge",
                "your pet seems painful or unwell"
        ));

        res.setDisclaimer("This is guidance only and not a diagnosis.");

        return res;
    }

    private AdviceResponse handleRash(AdviceRequest req) {

        AdviceResponse res = new AdviceResponse();
        res.setLabel("rash");

        boolean urgent =
                req.isBloodOrPus() ||
                req.isPetUnwell();

        boolean vetSoon =
                req.isScratching() ||
                req.isSpreading() ||
                req.isLastingDays();

        if (urgent) {
            res.setUrgency("urgent_now");
            res.setSummary("This rash may be serious and should be checked by a vet urgently.");
        }
        else if (vetSoon) {
            res.setUrgency("vet_soon");
            res.setSummary("This looks like a skin irritation that should be checked by a vet.");
        }
        else {
            res.setUrgency("home_care");
            res.setSummary("This may be a mild skin irritation that can be monitored.");
        }

        res.setPossibleCauses(List.of(
                "allergy",
                "skin irritation",
                "infection",
                "parasites"
        ));

        res.setSafeHomeCare(List.of(
                "Keep the area clean and dry",
                "Prevent licking or scratching",
                "Avoid applying human creams"
        ));

        res.setGoToVetIf(List.of(
                "the rash spreads",
                "there is blood or pus",
                "your pet becomes lethargic",
                "the irritation worsens"
        ));

        res.setDisclaimer("This is guidance only and not a diagnosis.");

        return res;
    }

    private AdviceResponse handleNormalSkin(AdviceRequest req) {

        AdviceResponse res = new AdviceResponse();
        res.setLabel("normal_skin");

        res.setUrgency("monitor");

        res.setSummary("No clear skin issue was detected from the image.");

        res.setPossibleCauses(List.of(
                "normal skin",
                "minor irritation not visible in image"
        ));

        res.setSafeHomeCare(List.of(
                "Monitor the area over the next few days",
                "Check for redness, swelling, or irritation",
                "Prevent excessive licking"
        ));

        res.setGoToVetIf(List.of(
                "symptoms appear",
                "your pet shows pain",
                "redness or swelling develops"
        ));

        res.setDisclaimer("Image analysis may miss subtle symptoms. Consult a vet if unsure.");

        return res;
    }
}