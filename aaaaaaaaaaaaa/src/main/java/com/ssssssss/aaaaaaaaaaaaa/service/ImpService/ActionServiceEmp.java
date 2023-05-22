package com.ssssssss.aaaaaaaaaaaaa.service.ImpService;

import com.ssssssss.aaaaaaaaaaaaa.common.dto.ActionDto;
 import com.ssssssss.aaaaaaaaaaaaa.common.entity.Action;
 import com.ssssssss.aaaaaaaaaaaaa.common.entity.Role;
import com.ssssssss.aaaaaaaaaaaaa.exception.NotFoundException;
import com.ssssssss.aaaaaaaaaaaaa.repository.ActionRepository;
import com.ssssssss.aaaaaaaaaaaaa.repository.RolesRepository;
import com.ssssssss.aaaaaaaaaaaaa.response.ResponseAction;
 import com.ssssssss.aaaaaaaaaaaaa.service.constrainedService.ActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssssssss.aaaaaaaaaaaaa.util.UtilMessage.endMessage;
import static com.ssssssss.aaaaaaaaaaaaa.util.UtilMessage.startMessage;
import static com.ssssssss.aaaaaaaaaaaaa.util.utilTime.end;
import static com.ssssssss.aaaaaaaaaaaaa.util.utilTime.start;


@Service
@RequiredArgsConstructor
@Slf4j
public class ActionServiceEmp implements ActionService {

    private final ModelMapper mapperAction;

    private final ActionRepository actionRepository;
    private final RolesRepository rolesRepository;



    @Override
    public ResponseAction addAction(ActionDto actionDto) {

        String methodName = "add action";

        log.info(startMessage, methodName);

        ResponseAction responseAction = new ResponseAction();

        boolean existsAction = actionRepository.
                existsByNameActionAndCodeAction(actionDto.getNameAction(), actionDto.getCodeAction());
        boolean existsRole = rolesRepository.existsById(actionDto.getIdRole());

        if (!existsAction && existsRole) {

            Action action = mapperAction.map(actionDto, Action.class);

            if (action != null) {

                Role role = rolesRepository.findById(actionDto.getIdRole()).get();

                action.setRole(role);

                actionRepository.save(action);
                log.info("expired success save action :: {}", action);

                ActionDto actionDto1 = mapperAction.map(action, ActionDto.class);

                responseAction.responseAction = actionDto1;
                responseAction.roleName = role.getRoleName();

            } else {
                responseAction.actionMessage = "should be send data action";

            }
        } else {
            if (existsAction) responseAction.actionMessage = "this the action is present already";
            if (!existsRole) responseAction.roleName = "not present data by this roleId";

        }
        log.info(endMessage, methodName, end - start);
        return responseAction;


    }

    @Override
    public ResponseAction getActionByID(int id) throws NotFoundException {

        String methodName = "get action By ID";
        log.info(startMessage, methodName);

        ResponseAction responseAction = new ResponseAction();

        boolean existsById = actionRepository.existsById(id);

        if (existsById) {

            Action action = actionRepository.findById(id).get();

            ActionDto actionDto = mapperAction.map(action, ActionDto.class);
             actionDto.setIdRole(0);

            responseAction.actionMessage = null;
            responseAction.responseAction = actionDto;
            responseAction.roleName = action.getRole().getRoleName();

            log.info(endMessage, methodName, end - start);
            return responseAction;

        } else {

            log.info(endMessage, methodName, end - start);

            throw new NotFoundException("action not Fount with id ::" + id);

        }
    }

    @Override
    public List<ResponseAction> getAllAction() throws NotFoundException {

        String methodName = "get All actions";
        log.info(startMessage, methodName);

        List<Action> actions = actionRepository.findAll();
        List<ResponseAction> responseActions =new ArrayList<>();

        if (actions.isEmpty()) {
            log.info(endMessage, methodName, end - start);
            throw new NotFoundException("not present employees");

        } else {
            List<ActionDto> actionDtos = actions.stream().map(action ->
                    mapperAction.map(action, ActionDto.class)).toList();
            List<String> roleNames = actions.stream().map(action -> action.getRole().getRoleName()).toList();

            int count = actions.size();
            for(int x=0 ; x<count; x++) {

                ResponseAction responseAction = new ResponseAction();
                responseAction.responseAction=actionDtos.get(x);
                responseAction.roleName=roleNames.get(x);

                responseActions.add(responseAction);

            }

        }
        log.info(endMessage, methodName, end - start);

        return responseActions;

    }

    @Override
    public ResponseAction updateAction(ActionDto actionDto)throws NotFoundException {

        String methodName = "update action";
        log.info(startMessage, methodName);

        ResponseAction responseAction = new ResponseAction();

        boolean existsByNameActionAndCodeAction = actionRepository.existsByNameActionAndCodeAction(actionDto.getNameAction(),
                actionDto.getCodeAction());
        boolean existsActionId = actionRepository.existsById(actionDto.getIdAction());

        Action action = actionRepository.findById(actionDto.getIdAction()).get();
        boolean existsRoeId = action.getRole().getRoleId() == actionDto.getIdRole() ;

        if (!existsByNameActionAndCodeAction|| !existsRoeId ) {
            if (existsActionId) {

                Action action1 = mapperAction.map(actionDto, Action.class);
                action1.setAcId(actionDto.getIdAction());

                actionRepository.save(action1);

                responseAction.responseAction=actionDto;
                responseAction.roleName = action.getRole().getRoleName();

            } else {

                log.info(endMessage, methodName, end - start);

                throw new NotFoundException("the employeeId is not present");
            }
        }
        else {

            log.info(endMessage, methodName, end - start);

            throw new NotFoundException("this action is present");

        }
        log.info(endMessage, methodName, end - start);
        return responseAction ;

    }
}
